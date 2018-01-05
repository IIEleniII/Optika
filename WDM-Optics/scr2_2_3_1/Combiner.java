import java.util.Iterator;
import java.util.Map.Entry;

/*
 * Packet Collision Observation
 * 
 * Checks to see if  two stations happen to try broadcasting at the same wavelength
 * If so, these packets are dismissed and the total number of packets broadcasted from both stations changes
 * 
 * */
public class Combiner {
	private static final Long NULL = null;
	// Packet Collision Observation

	private static final Boolean FALSE = null;
	private static final Boolean TRUE = null;

	int pc1PacketsLeft;
	int pc2PacketsLeft;
	// static int totalpacketsentPc1;
	// static int totalpacketsentPc2;
	static int totalpacketsent_AC;
	int counter = 0;

	Long delay ;
	Long delay1 ;
	Long delay2;

	private Long delaySum;

	// Compare PC1 map with PC2 map and save the total number of packets broadcasted
	// from both stations
	public void compare_packet_list(PC pc1, PC pc2, int pc1size, int pc2size) {
		// if(pc1.map_value(key)==pc2.map_value(key)) {
		System.out.println("PC1:Keys" + pc1.map_keySet() + "values:" + pc1.map_values());
		System.out.println("PC2:Keys" + pc2.map_keySet() + "values:" + pc2.map_values());

		// System.out.println("PC2:"+pc2.map_value(key));
		// Boolean flag=compare(pc1,pc2);
		// if(flag==1) {
		// pc1.map_remove(key);
		// pc2.map_remove(key);

		compare(pc1, pc2);

		// System.out.println("sIZE PC1" + pc1.map_size());
		// System.out.println(counter);
		pc1PacketsLeft = pc1.map_size();
		// pc1PacketsLeft = pc1.map_size() - counter;
		// System.out.println("Total packet sent PC1:"+pc1PacketsLeft);
		// pc2PacketsLeft = pc2.map_size() - counter;
		pc2PacketsLeft = pc2.map_size();
		// System.out.println("Total packet sent PC1:"+pc2PacketsLeft);
		System.out.println("PC1:Keys" + pc1.map_keySet() + "values:" + pc1.map_values());
		System.out.println("PC2:Keys" + pc2.map_keySet() + "values:" + pc2.map_values());

		// totalpacketsentPc1=pc1size-pc1PacketsLeft;
		// System.out.println("Total packet delay sent PC1:"+PacketDelay(pc1));
		// System.out.println("Total packet delay sent PC2:"+ PacketDelay(pc2));
		// totalpacketsentPc2=pc2size-pc2PacketsLeft;
		totalpacketsent_AC = pc1PacketsLeft + pc2PacketsLeft;
		
		delay1 = PacketDelay(pc1);
		delay2 = PacketDelay(pc2);
		
		
		System.out.println("Total packet sent:" + totalpacketsent_AC + "Total delay" + totalPacketdelay(delay1,delay2));

		// System.out.println("PC1:"+pc1.map_value(key));
		// System.out.println("PC2:"+pc2.map_value(key));
		// }
		// else {
		//
		// System.out.println("continue");
		// }

	}

	// Comparison using the keys of the maps
	public void compare(PC pc1, PC pc2) {
		
//		Iterator<Integer> iter2 = (Iterator<Integer>) pc2.map_keySet().iterator();
//		Iterator<Integer> iter1 = (Iterator<Integer>) pc1.map_keySet().iterator();
//		
//		while(iter2.hasNext()) {
//			int entry2 =iter2.next();
//			while(iter1.hasNext()) {
//				int entry1=iter1.next();
//				if (entry2==entry1) { 
//					System.out.println("There's been a collision");
//					pc2.map_remove_all(entry2, pc2.map_value(entry2));
//					pc1.map_remove_all(entry1, pc1.map_value(entry1));
//					} else {
//						
//						System.out.println("None same keys yet");
//					}
//			}
//		}
//		

		for (Integer entry2 : pc2.map_keySet()) {

			for (Integer entry1 : pc1.map_keySet()) {

				if (entry2.equals(entry1)) { // If keys are the same

					System.out.println("There's been a collision");
					// System.out.println(entry1.getKey()+"and pc2"+entry2.getKey());
					pc2.map_remove_all(entry2, pc2.map_value(entry2));
					pc1.map_remove_all(entry1, pc1.map_value(entry1));
					// counter++; // Counts the times of collision
					// // pc1PacketsLeft=pc1.map_size();
					//// System.out.println("size1 :"+pc1.map_size());
					//// pc2PacketsLeft=pc2.map_size();
					//// System.out.println("size2 :"+pc2.map_size());
					//
				} else {

					System.out.println("None same keys yet");
				}
			}

		}
	}

	/*
	 * Total number of broadcasted packets from stations after some broadcasting
	 * denial on same wavelength packets
	 */
	public int TotalPacketsSent_AC() {
		return totalpacketsent_AC;
	}

	public Long PacketDelay(PC pc) {
		

		for (int i = 0; i < pc.map_size(); i++) {
			if (pc.map_key(i)==TRUE) {
				if (pc.map_value(i) == null) {
					continue;
				} else {
					delaySum += pc.map_value(i);
				}
			} else {
				continue;
			}
		}
		return delaySum;

	}

	public Long totalPacketdelay(Long delay1,Long delay2) {
//		delay1 = PacketDelay(pc1);
//		delay2 = PacketDelay(pc2);
		if (delay1 == null && delay2 != null) {
			delay=(long) 5000;
//			delay = delay2;
		} else if (delay1 != null && delay2 == null) {
			delay=(long) 6000;
//			delay = delay1;
		} else if (delay1 == null && delay2 == null) {
			delay = null;
		} else {
			delay = delay1 + delay2;
		}
		return delay;
	}
}
