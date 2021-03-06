
/**
 * 
 */
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

/**
 * @author trach
 *
 */
public class PC {

	private int id;
	private int rmv_pck;
	private double probability = 0;
	
	public static int slots=0;

	private int i = 0;
	private random rand = new random();

	private Packet pck = new Packet();
	private PriorityQueue<Integer> wait_queue = new PriorityQueue<Integer>();
	private Map<Integer, Long> packet_line = new Hashtable<Integer, Long>();
	// private PriorityQueue<Long> timer_queue = new PriorityQueue<Long>();
	private Map<Integer, Long> map = new Hashtable<Integer, Long>();
	long exit_queue, insert_queue;

	// //Generates Random numbers
	// public double random(){
	//
	// double randomfloat=0;
	//
	// Random randomGenerator = new Random();
	// randomfloat = (float) (randomGenerator.nextFloat()*(1-0.1));
	//
	// return randomfloat;
	// }

	public Set<Integer> map_keySet() {
		return map.keySet();
	}
	
	public Boolean map_key(int key) {
		return map.containsKey(key);
	}

	public Collection<Long> map_values() {
		return map.values();
	}

	public Long map_value(int key) {
		return map.get(key);
	}

	public void map_remove(int key) {
		map.remove(key);
	}
	

	public int map_size() {
		return map.size();
	}
//
//	public Set<Entry<Integer, Long>> entrySet() {
//		return map.entrySet();
//	}

	public void map_remove_all(int key, long value) {
		map.remove(key, value);
	}

	public void arrive_broadcast_In_Queue(double probability) { // ,int i ) { //Check if packet gets in and out of queue
		// probability=random();
		// while(probability>0.3) {

		// greater possibility to be broadcasted, as it's closer to p=1
		if (wait_queue.isEmpty()) {
			pck.set_id(i);
			packet_line.put(pck.get_id(), pck.start_timer());
			wait_queue.add(i);
			Object[] arr = wait_queue.toArray();
			slots++;
			
			// System.out.println("queue my empty first:"+ arr[i].toString());
			// System.out.println("Probability is: "+probability);
			// System.out.println("line contains key:"+ packet_line.keySet());
			// System.out.println("line contains start time:"+ packet_line.values());

			if (probability == 0.5 && probability < 0.6) {

				// if(map.containsKey(wait_queue.peek())) {
				pck.set_id(wait_queue.peek());

				map.put(pck.get_id(), (pck.stop_timer() - packet_line.get(pck.get_id())));
						//				map.put(pck.get_id(), (pck.stop_timer() - pck.start_timer())); // map.put(pck.get_id(),(pck.stop_timer()-map.getValue()));
				rmv_pck = wait_queue.poll();
				packet_line.remove(rmv_pck);
				
				 System.out.println("polled:" + rmv_pck);
				 System.out.println("My packet line:" + packet_line.size());
				System.out.println("My map of packets for initial empty line is " + map.keySet());
				probability = rand.random();
				i++;
			} else {

				System.out.println("Not packet broadcasted");
				System.out.println("My waiting line:" + wait_queue);
				probability = rand.random();
				i++;
			}

			// if(test==0) {//probability ==0.5
			//
			// }
		}
		// else{
		if (wait_queue.size() != 0 && wait_queue.size() <5) {
			pck.set_id(i);
			packet_line.put(pck.get_id(), pck.start_timer());
			wait_queue.add(i);
			slots=slots+1;
			
			
			Object[] arr = wait_queue.toArray();
			// System.out.println("queue wa first:"+ arr[i].toString());
			// System.out.println("Probability is: "+probability);
			// System.out.println("line contains key:"+ packet_line.keySet());
			// System.out.println("line contains start time:"+ packet_line.values());
			//
			//
			// System.out.println("Has waited in afull queue:"+wait_queue.peek());
			if (probability > 0.5 && probability < 0.6) {
				// if(map.containsKey(wait_queue.peek())) {
				pck.set_id(wait_queue.peek());
				
				map.put(pck.get_id(), (pck.stop_timer() - packet_line.get(pck.get_id())));
				System.out.println("My packet line before:" + packet_line);
				//map.put(pck.get_id(), (pck.stop_timer() - pck.start_timer())); // map.put(pck.get_id(),(pck.stop_timer()-map.getValue()));
				rmv_pck = wait_queue.poll();
				packet_line.remove(rmv_pck);
				
				 System.out.println("polled:" + rmv_pck);
				System.out.println("My packet line:" + packet_line);
				System.out.println("My packet line:" + packet_line.size());
				System.out.println("My map of packets for a non empty line is " + map.keySet());
				probability = rand.random();
				i++;
			} else {

				System.out.println("Not packet broadcasted in a non empty queue");
				//System.out.println("My packet line:" + packet_line);
				System.out.println("My waiting line:" + wait_queue);
				probability = rand.random();
				i++;

			}
		}
		// }
		if (wait_queue.size() > 5) {
			if (probability > 0.5 && probability < 0.6) {
				// if(map.containsKey(wait_queue.peek())) {
				pck.set_id(wait_queue.peek());

				map.put(pck.get_id(), (pck.stop_timer() - packet_line.get(pck.get_id())));
				
			//	map.put(pck.get_id(), (pck.stop_timer() - pck.start_timer())); // map.put(pck.get_id(),(pck.stop_timer()-map.getValue()));
				rmv_pck = wait_queue.poll();
				packet_line.remove(rmv_pck);

			 System.out.println("My packet line for line >9:" + packet_line.size());
				System.out.println("My map of packets for line >9 is " + map.keySet());
				pck.set_id(i);
				packet_line.put(pck.get_id(), pck.start_timer());
				wait_queue.add(i);
				probability = rand.random();
				i++;
			} else {
				System.out.println("Access denied");
				//System.out.println("My packet line:" + packet_line);
				System.out.println("My waiting line:" + wait_queue);
				probability = rand.random();
				i++;
			}
		}

	}
	

}
