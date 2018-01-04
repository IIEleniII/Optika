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
	private int test=0;
	
	private Packet pck = new Packet();
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
	
	int i=0;
	
	public void arrive_broadcast_In_Queue() { //Check if packet gets in and out of queue 
		double probability=random();
		 while(probability>0.3) {
			 
			  //greater possibility to be broadcasted, as it's closer to p=1
				if(wait_queue.size()== 0) {
					pck.set_id(i);
					packet_line.put(pck.get_id(),pck.start_timer());
					wait_queue.add(i);
					Object[] arr = wait_queue.toArray(); 
					System.out.println("queue wa emty first:"+ arr[i].toString());
					System.out.println("line contains:"+ packet_line.keySet());
					System.out.println("line contains:"+ packet_line.values());
					
					 
					
					if(test==0) {//probability ==0.5
					 if(map.containsKey(wait_queue.peek())) {
							pck.set_id(wait_queue.peek());
							
							map.put(pck.get_id(),(pck.stop_timer()-pck.start_timer())); //map.put(pck.get_id(),(pck.stop_timer()-map.getValue()));
							int rmv_pck=wait_queue.poll();
							packet_line.remove(rmv_pck);
							System.out.println("My packet line:" + packet_line);
					 }
					}
				}
				else{
					if(wait_queue.size()>0 && wait_queue.size()<4) {
					pck.set_id(i);
					packet_line.put(pck.get_id(),pck.start_timer());
					wait_queue.add(i);
					Object[] arr = wait_queue.toArray(); 
					System.out.println("queue wa first:"+ arr[i].toString());
					System.out.println("line contains:"+ packet_line.keySet());
					System.out.println("line contains:"+ packet_line.values());
					
					
					//System.out.println("Has waited in afull  queue:"+wait_queue.peek());
					if(probability==0.5) {
						if(map.containsKey(wait_queue.peek())) {
							pck.set_id(wait_queue.peek());
							
							map.put(pck.get_id(),(pck.stop_timer()-pck.start_timer())); //map.put(pck.get_id(),(pck.stop_timer()-map.getValue()));
							int rmv_pck=wait_queue.poll();
							packet_line.remove(rmv_pck);
							 System.out.println ( "Priority queue values are: "+ wait_queue);
						      
							
							}																												
						}
					}
				}
				
				
				i++;
		 }
		
		}
	}
	



	
	

