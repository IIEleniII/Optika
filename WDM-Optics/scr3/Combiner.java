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
	// Packet Collision Observation

	private static final Boolean FALSE = null;
	private static final Boolean TRUE = null;

	int pc1PacketsLeft;
	int pc2PacketsLeft;
	// static int totalpacketsentPc1;
	// static int totalpacketsentPc2;
	static int totalpacketsent_AC;
	int counter = 0;

	Long delay=(long) -1;
	Long delay1;
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
		// pc1PacketsLeft = pc1.map_size();
		pc1PacketsLeft = pc1.map_size() - counter;
		// System.out.println("Total packet sent PC1:"+pc1PacketsLeft);
		pc2PacketsLeft = pc2.map_size() - counter;
		// pc2PacketsLeft = pc2.map_size();
		// System.out.println("Total packet sent PC1:"+pc2PacketsLeft);
		// System.out.println("PC1:Keys" + pc1.map_keySet() + "values:" +
		// pc1.map_values());
		// System.out.println("PC2:Keys" + pc2.map_keySet() + "values:" +
		// pc2.map_values());

		// totalpacketsentPc1=pc1size-pc1PacketsLeft;
		// System.out.println("Total packet delay sent PC1:"+PacketDelay(pc1));
		// System.out.println("Total packet delay sent PC2:"+ PacketDelay(pc2));
		// totalpacketsentPc2=pc2size-pc2PacketsLeft;
		totalpacketsent_AC = pc1PacketsLeft + pc2PacketsLeft;
		//
		// delay1 = PacketDelay(pc1);
		// delay2 = PacketDelay(pc2);
		//
		
		System.out.println("Total packet sent:" + totalpacketsent_AC );// delay1,delay2
		// System.out.println("TEST :" + PacketDelay(pc1));

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
		Properties props = System.getProperties();
		synchronized (props) {
			// int entry2, entry1;
			//
			// Iterator<Integer> iter2 = pc2.map_keySet().iterator();
			// Iterator<Integer> iter1 = pc1.map_keySet().iterator();
			//
			// while(iter2.hasNext()) {
			// entry2 =iter2.next();
			// while(iter1.hasNext()) {
			// entry1 =iter1.next();
			// if (entry2==entry1) {
			// if(pc2.map_value(entry2)==null || pc1.map_value(entry1)==null) {
			// System.out.println("empty space");
			// //continue;
			// }else if(pc2.map_value(entry2)!=null && pc1.map_value(entry1)!=null){
			// System.out.println("There's been a collision");
			// pc2.map_remove_all(entry2, pc2.map_value(entry2));
			// pc1.map_remove_all(entry1, pc1.map_value(entry1));
			// }
			// }else {
			//
			// System.out.println("None same keys yet");
			// }
			// }
			// }
			// }
			// }

			// for (Integer entry2 : pc2.map_keySet()) {
			//
			// for (Integer entry1 : pc1.map_keySet()) {
			//
			// if (entry2.equals(entry1)) { // If keys are the same
			//
			// System.out.println("There's been a collision");
			// // System.out.println(entry1.getKey()+"and pc2"+entry2.getKey());
			// pc2.map_remove_all(entry2, pc2.map_value(entry2));
			// pc1.map_remove_all(entry1, pc1.map_value(entry1));
			// // counter++; // Counts the times of collision
			// // // pc1PacketsLeft=pc1.map_size();
			// //// System.out.println("size1 :"+pc1.map_size());
			// //// pc2PacketsLeft=pc2.map_size();
			// //// System.out.println("size2 :"+pc2.map_size());
			// //
			// } else {
			//
			// System.out.println("None same keys yet");
			// }
			// }
			//
			// }
			ArrayList<Integer> collision_key_collector = new ArrayList<Integer>();

			for (Integer entry2 : pc2.map_keySet()) {

				for (Integer entry1 : pc1.map_keySet()) {

					if (entry2.equals(entry1)) { // If keys are the same

						System.out.println("There's been a collision");
						// System.out.println(entry1.getKey()+"and pc2"+entry2.getKey());
						// pc2.map_remove_all(entry2, pc2.map_value(entry2));
						// pc1.map_remove_all(entry1, pc1.map_value(entry1));
						counter++; // Counts the times of collision
						collision_key_collector.add(entry1); // saves the packet key which collied
						// System.out.println("Counter:"+counter);
						// // pc1PacketsLeft=pc1.map_size();
						//// System.out.println("size1 :"+pc1.map_size());
						//// pc2PacketsLeft=pc2.map_size();
						//// System.out.println("size2 :"+pc2.map_size());
						//
					} else {

						System.out.println("None same keys yet");
						continue;
					}
				}
			}
			delay1=Search(pc1,collision_key_collector).longValue() ;
			delay2=Search(pc2,collision_key_collector).longValue() ;
			if(delay1<0 && delay2<0) {
				System.out.println("Collision occured in queues consisting of only one packet.So The delay is negative as there was indeed dealy for those packets,but not for others to come");
				delaySum=delay1.longValue() + delay2.longValue();
				System.out.println("Delay total:"+delaySum.longValue() );
			}
			System.out.println("Delay total:"+(delay1.longValue() + delay2.longValue() ));

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
						if (j == search) {
							continue;
						}
						delay+=(long)pc.map_value(j);
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

	//
	// public Long PacketDelay(PC pc) {
	// //delaySum = null;
	// if(pc.map_size()==0) {
	// delaySum=null;
	// }else {
	// for (int i = 0; i < pc.map_size()+1; i++) {
	// if (pc.map_key(i)==TRUE) {
	// if (pc.map_value(i) != null) {
	// delaySum = delaySum+ pc.map_value(i);
	//
	// } else {
	// continue;
	// }
	// } else {
	// continue;
	// }
	// }
	// }
	// return delaySum;
	//
	// }
	//
	// public Long totalPacketdelay(PC pc1,PC pc2) {//Long delay1,Long delay2
	// delay1 = PacketDelay(pc1);
	// delay2 = PacketDelay(pc2);
	//
	// if(delay1!=null) {
	// if(delay2!=null) {
	// delay = delay1 + delay2;
	// }else {
	// delay=(long) 6000;
	// }
	// }else {
	// if(delay2!=null) {
	// delay = (long) 5000;
	// }else {
	// delay=null;
	// }
	// }
	// return delay;
	//
	// }

	// if (delay1 == null && delay2 != null) {
	// delay=(long) 5000;
	//// delay = delay2;
	// } else if (delay1 != null && delay2 == null) {
	// delay=(long) 6000;
	//// delay = delay1;
	// } else if (delay1 == null && delay2 == null) {
	// delay = null;
	// } else {
	// delay = delay1 + delay2;
	// }
	// return delay;
	// }
}
