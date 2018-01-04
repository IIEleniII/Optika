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
	private Map<Integer,Long> packet_line=new Hashtable<Integer,Long>(); 
	//private PriorityQueue<Long> timer_queue = new PriorityQueue<Long>();
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
				if(wait_queue.size()== 0) {
					pck.set_id(i);
					packet_line.put(pck.get_id(),pck.start_timer());
					wait_queue.add(i);
					
					System.out.print("iT'S:"+wait_queue.toArray());
					
					if(random()==0.5) {
						if(map.containsKey(wait_queue.peek())) {
							pck.set_id(wait_queue.peek());
							
							map.put(pck.get_id(),(pck.stop_timer()-pck.start_timer())); //map.put(pck.get_id(),(pck.stop_timer()-map.getValue()));
							packet_line.remove(wait_queue.peek());
							wait_queue.poll();
					}else {continue;}
				}else {
				if(wait_queue.size()>0 && wait_queue.size()<4) {
					pck.set_id(i);
					packet_line.put(pck.get_id(),pck.start_timer());
					wait_queue.add(i);
					
					if(random()==0.5) {
						if(map.containsKey(wait_queue.peek())) {
							pck.set_id(wait_queue.peek());
							
							map.put(pck.get_id(),(pck.stop_timer()-pck.start_timer())); //map.put(pck.get_id(),(pck.stop_timer()-map.getValue()));
							packet_line.remove(wait_queue.peek());
							wait_queue.poll();
							
						}																												
					}else {continue;}
					
				}
				if(wait_queue.size()>3) {
					System.out.println("No available space in queue");
				}
			}
			}
		
		}
	}
	}
}

	
	

