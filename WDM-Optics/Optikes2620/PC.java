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

	public static double prob;
	public static int slots = 0;
	public final static int waitingline_size = 5;
	private int id;
	private int rmv_pck;
	private double probability = 0;
	private int i = 0;
	private random rand = new random();
	private Packet pck = new Packet();
	private PriorityQueue<Integer> wait_queue = new PriorityQueue<Integer>(); // Initial queue for packets to get in
	private Map<Integer, Long> packet_line = new Hashtable<Integer, Long>(); // middle stage where packets are saved
	private Map<Integer, Long> map = new Hashtable<Integer, Long>();// packets which passed the broadcast checks for PC

	// MAP handling functions
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

	public void map_remove_all(int key, long value) {
		map.remove(key, value);
	}

	//
	// Check if packet gets in and out of queue
	public void arrive_broadcast_In_Queue(double probability) {

		if (wait_queue.isEmpty()) {
			pck.set_id(i);
			packet_line.put(pck.get_id(), pck.start_timer());
			wait_queue.add(i);
			Object[] arr = wait_queue.toArray();
			slots++;
			// possibility for packet to be broadcasted set between 0.5 to 0.6
			if (probability == 0.5 && probability < 0.6) {

				pck.set_id(wait_queue.peek());

				map.put(pck.get_id(), (pck.stop_timer() - packet_line.get(pck.get_id()))); // Adds in map packet id,
																							// wait period before it is
																							// broadcasted

				rmv_pck = wait_queue.poll(); // remove from initial queue
				packet_line.remove(rmv_pck);// remove from middle stage where packets are saved
				prob = probability;// save probability

				System.out.println("My map of packets for initial empty line is " + map.keySet());
				probability = rand.random();
				i++;
			} else {

				System.out.println("Not packet broadcasted");
				prob = probability;

				probability = rand.random();
				i++;
			}

		}

		if (wait_queue.size() != 0 && wait_queue.size() < waitingline_size) {
			pck.set_id(i);
			packet_line.put(pck.get_id(), pck.start_timer());
			wait_queue.add(i);
			slots = slots + 1;

			Object[] arr = wait_queue.toArray();

			if (probability > 0.5 && probability < 0.6) {

				pck.set_id(wait_queue.peek());
				prob = probability;
				map.put(pck.get_id(), (pck.stop_timer() - packet_line.get(pck.get_id())));

				rmv_pck = wait_queue.poll();
				packet_line.remove(rmv_pck);

				System.out.println("My map of packets for a non empty line is " + map.keySet());
				probability = rand.random();
				i++;
			} else {

				System.out.println("Not packet broadcasted in a non empty queue");
				prob = probability;

				probability = rand.random();
				i++;

			}
		}

		if (wait_queue.size() > waitingline_size) {
			if (probability > 0.5 && probability < 0.6) {

				pck.set_id(wait_queue.peek());

				map.put(pck.get_id(), (pck.stop_timer() - packet_line.get(pck.get_id())));

				rmv_pck = wait_queue.poll();
				packet_line.remove(rmv_pck);
				prob = probability;

				System.out.println("My packet line for line >9:" + packet_line.size());

				pck.set_id(i);
				packet_line.put(pck.get_id(), pck.start_timer());
				wait_queue.add(i);
				probability = rand.random();
				i++;
			} else {
				System.out.println("Access denied");
				prob = probability;

				System.out.println("My waiting line:" + wait_queue);
				probability = rand.random();
				i++;
			}
		}

	}

	public double probability() {
		return prob;
	}

}
