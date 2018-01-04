
/**
 * 
 */
import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

/**
 * @author trach
 *
 */
public class PC {
		
	private int id ;
	private int rmv_pck;
	private double probability=0;
	
	private int i=0;
	private random rand=new random();
	
	private Packet pck = new Packet();
	private PriorityQueue<Integer> wait_queue = new PriorityQueue<Integer>();
	private Map<Integer,Long> packet_line=new Hashtable<Integer,Long>(); 
	//private PriorityQueue<Long> timer_queue = new PriorityQueue<Long>();
	private Map<Integer,Long> map=new Hashtable<Integer,Long>(); 
	long exit_queue , insert_queue;
	
	
//	//Generates Random numbers
//	public  double random(){
//		
//		double randomfloat=0;
//	    
//	    Random randomGenerator = new Random();
//	    randomfloat = (float) (randomGenerator.nextFloat()*(1-0.1));
//	    
//		return randomfloat;
//	}
	

	public Long map_value(int key){
		return map.get(key);
	}
	
	public void map_remove(int key) {
		map.remove(key);
	}
	
	public int map_size() {
		return map.size();
	}
	
	
	
	
	public void arrive_broadcast_In_Queue(double probability) { //,int i ) { //Check if packet gets in and out of queue 
//		 probability=random();
//		 while(probability>0.3) {
			 
			  //greater possibility to be broadcasted, as it's closer to p=1
				if(wait_queue.isEmpty()) {
					pck.set_id(i);
					packet_line.put(pck.get_id(),pck.start_timer());
					wait_queue.add(i);
					Object[] arr = wait_queue.toArray(); 
					System.out.println("queue my empty first:"+ arr[i].toString());
					System.out.println("Probability is: "+probability);
//					System.out.println("line contains key:"+ packet_line.keySet());
//					System.out.println("line contains start time:"+ packet_line.values());
					
					if(probability==0.5 && probability<0.6) {
					 
					  //if(map.containsKey(wait_queue.peek())) {
										pck.set_id(wait_queue.peek());
							
											map.put(pck.get_id(),(pck.stop_timer()-pck.start_timer())); //map.put(pck.get_id(),(pck.stop_timer()-map.getValue()));
												 rmv_pck=wait_queue.poll();
													packet_line.remove(rmv_pck);
													
//														System.out.println("My packet line:" +  packet_line.size());
														System.out.println("My map of packets is "+ map.keySet());
														 probability=rand.random();
														 i++;
					}else {
					 
					  System.out.println("Not packet broadcasted");
					  probability=rand.random();
					 			i++;
					 }
					
//					if(test==0) {//probability ==0.5
//					
//					}
				}
				//else{
					if(wait_queue.size()!=0 && wait_queue.size()<9) {
					pck.set_id(i);
					packet_line.put(pck.get_id(),pck.start_timer());
					wait_queue.add(i);
					Object[] arr = wait_queue.toArray(); 
					System.out.println("queue wa first:"+ arr[i].toString());
					System.out.println("Probability is: "+probability);
//					System.out.println("line contains key:"+ packet_line.keySet());
//					System.out.println("line contains start time:"+ packet_line.values());
//					
//					
					//System.out.println("Has waited in afull  queue:"+wait_queue.peek());
					if(probability>0.5 && probability<0.6) {
						  //if(map.containsKey(wait_queue.peek())) {
						pck.set_id(wait_queue.peek());
			
							map.put(pck.get_id(),(pck.stop_timer()-pck.start_timer())); //map.put(pck.get_id(),(pck.stop_timer()-map.getValue()));
								rmv_pck=wait_queue.poll();
									packet_line.remove(rmv_pck);
									
//										System.out.println("My packet line:" +  packet_line.size());
										System.out.println("My map of packets is "+ map.keySet());
										 probability=rand.random();
										i++;
						}else {
	 
								System.out.println("Not packet broadcasted now");
								 probability=rand.random();
								i++;
	 			
							}
					}
				//}
				if(wait_queue.size()>9) {
					if(probability>0.5 && probability<0.6) {
						  //if(map.containsKey(wait_queue.peek())) {
						pck.set_id(wait_queue.peek());
			
							map.put(pck.get_id(),(pck.stop_timer()-pck.start_timer())); //map.put(pck.get_id(),(pck.stop_timer()-map.getValue()));
								rmv_pck=wait_queue.poll();
									packet_line.remove(rmv_pck);
									
//										System.out.println("My packet line:" +  packet_line.size());
										System.out.println("My map of packets is "+ map.keySet());
										  pck.set_id(i);
											packet_line.put(pck.get_id(),pck.start_timer());
											wait_queue.add(i);
											 probability=rand.random();
											i++;
						}
					else {
						System.out.println("Access denied");
						 probability=rand.random();
						i++;
					}
				}
				
		 }
		
		//}
	}
	



	
	

