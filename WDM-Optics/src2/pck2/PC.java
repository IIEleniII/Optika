/**
 * 
 */
package pck2;
import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @author trach
 *
 */
public class PC {
		
	private int id;
	private Packet pck;
	private PriorityQueue<Integer> wait_queue = new PriorityQueue<Integer>();
	private PriorityQueue<Long> timer_queue = new PriorityQueue<Long>();
	private Map<Integer,Long> map=new Hashtable<Integer,Long>(); 
	long exit_queue , insert_queue;
	
	
	
	public  double random(){
		
		double randomfloat=0;
	    
	    Random randomGenerator = new Random();
	    randomfloat = (float) (randomGenerator.nextFloat()*(1-0.1));
	    
		return randomfloat;
	}
	
	public void arrive_broadcast_In_Queue() { //Check if packet gets in and out of queue 
		for(int i=0;i<4;i++) {
			if(random()>0.3) { //greater possibility to be broadcasted, as it's closer to p=1
				if(wait_queue.size()== 0 && timer_queue.size()==0) {
					insert_queue=pck.start_timer();
					timer_queue.add(insert_queue);
					wait_queue.add(i);
					if(random()==0.5) {
						exit_queue=pck.stop_timer();
						map.put(i,exit_queue); //Table for exit time of the packet
						timer_queue.poll();
						wait_queue.poll();
					}
				}else {
				if(wait_queue.size()>0 && wait_queue.size()<4 && timer_queue.size()>0 && timer_queue.size()<4) {
					insert_queue=pck.start_timer();
					timer_queue.add(insert_queue);
					wait_queue.add(i);
					if(random()==0.5) {
						exit_queue=pck.stop_timer();
						map.put(i-1,exit_queue); //Table for exit time of the packet
						timer_queue.poll();
						wait_queue.poll();
					}
					
				}
				if(wait_queue.size()>3) {
					System.out.println("No available space in queue");
				}
			}
			}
		//mesa sti queue
		//energopoihsh timer in
		}
	}
	
//	public long broadcast_Packet() {
//		return exit_queue;
//		//na bgei apo tin queue 
//		//na krati8ei o xronos pou bgainei, gia sugkrish!!!
//	}
	
	public long slot_time() {
		return (exit_queue- insert_queue);
		//stop-start_timer=xronos ka8usterishw= xrono paketou=slot
	}
	
	
}
