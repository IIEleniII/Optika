import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/*
 * Packet Collision Observation
 * 
 * Checks to see if  two stations happen to try broadcasting at the same wavelength
 * If so, these packets are dismissed and the total number of packets broadcasted from both stations changes
 * 
 * */
public class Combiner {
	private static final Long NULL = null;

	private static final Boolean FALSE = null;
	private static final Boolean TRUE = null;

	int pc1PacketsLeft;
	int pc2PacketsLeft;

	static int totalpacketsent_AC;
	int counter = 0;

	Long delay = (long) -1;
	Long delay1;
	Long delay2;

	public static Long delaySum;

	public void compare_packet_list(PC pc1, PC pc2, int pc1size, int pc2size) {

		System.out.println("PC1:Keys" + pc1.map_keySet() + "values:" + pc1.map_values());
		System.out.println("PC2:Keys" + pc2.map_keySet() + "values:" + pc2.map_values());

		compare(pc1, pc2);

		pc1PacketsLeft = pc1.map_size() - counter;

		pc2PacketsLeft = pc2.map_size() - counter;

		totalpacketsent_AC = pc1PacketsLeft + pc2PacketsLeft;

		//System.out.println("Total packet sent:" + totalpacketsent_AC);// 

	}

	// Comparison using the keys of the maps
	public void compare(PC pc1, PC pc2) {
		Properties props = System.getProperties();
		synchronized (props) {

			ArrayList<Integer> collision_key_collector = new ArrayList<Integer>();

			for (Integer entry2 : pc2.map_keySet()) {

				for (Integer entry1 : pc1.map_keySet()) {

					if (entry2.equals(entry1)) { // If keys are the same

						System.out.println("There's been a collision");
						counter++; // Counts the times of collision
						collision_key_collector.add(entry1); // saves the packet key which collied

					} else {

						System.out.println("None same keys yet");
						continue;
					}
				}
			}
			delay1 = Search(pc1, collision_key_collector).longValue();
			delay2 = Search(pc2, collision_key_collector).longValue();
			delaySum = delay1.longValue() + delay2.longValue();
			if (delaySum < 0) {
				System.out.println(
						"Collision occured in queues consisting of only one packet.So The delay is negative as there was indeed dealy for those packets,but not for others to come");

				System.out.println("Delay total:" + delaySum.longValue());
			}

			System.out.println("Delay total:" + delaySum.longValue());

		}
	}

	public Long Search(PC pc, ArrayList<Integer> arraylist) {
		int search;
		if (arraylist.size() == 0) {
			System.out.println("No collision occured");

		} else {
			for (int i = 0; i < arraylist.size(); i++) {
				search = arraylist.get(i);
				for (int j = 0; j < pc.map_size(); j++) {
					if (j == search) { //ignore packets that collied
						continue;
					}
					delay += (long) pc.map_value(j);
					
					System.out.println(pc.map_value(j));
				}

			}
		}
		return delay;
	}

	/*
	 * Total number of broadcasted packets from stations after some broadcasting
	 * denial on same wavelength packets
	 */
	public int TotalPacketsSent_AC() {
		return totalpacketsent_AC;
	}

}
