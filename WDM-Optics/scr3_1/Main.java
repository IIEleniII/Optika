import java.util.Random;



public class Main {

	public static void main(String[] args) {
		
		double probability;
		int f = 0, k = 0;
		int totalpacketsent = 0;
		double throughput = 0;
		Long average_Delay = (long) 0;
		Long thedelay = (long) 0;
		random rand = new random();

		final int PACKETNUMBER = 10;

		PC pc1 = new PC();
		PC pc2 = new PC();

		Combiner combine = new Combiner();

		
		// 100packet sent
		
		
		for (f = 0; f < PACKETNUMBER; f++) {
			probability = rand.random();
			System.out.println("PC1");
			if (probability < 0.3) {
				continue;
			} else {
				pc1.arrive_broadcast_In_Queue(probability);
				// pc2.arrive_broadcast_In_Queue(probability);
				// probability=random();
			}
		}

		for (f = 0; f < PACKETNUMBER; f++) {
			probability = rand.random();
			System.out.println("PC2");
			if (probability < 0.3) {
				continue;
			} else {
				pc2.arrive_broadcast_In_Queue(probability);
				// pc2.arrive_broadcast_In_Queue(probability);
				// probability=random();
			}

			// if (probability > 0.3) {
			//
			// pc2.arrive_broadcast_In_Queue(probability);
			// // probability=random();
			// }
		}

		// for(int j=0;j<(pc1.map_size()+1);j++) {
		if (pc1.map_size() == 0 && pc2.map_size() == 0) {
			System.out.println("Empty maps.No broadcast from any PCS" + totalpacketsent);
			// totalpacketsent = 0;
			// PC.slots = 0;
			// thedelay = (long) 0;
			average_Delay = (long) 0;
			throughput = 0;

		}
		if (pc1.map_size() == 0 && pc2.map_size() != 0) {
			totalpacketsent = pc2.map_size();
			System.out.println("PC2 will broadcast:" + totalpacketsent + "packets");
			PC.slots = totalpacketsent;
			thedelay = (long) 0;
			throughput = (double) totalpacketsent / (double) PC.slots;
			average_Delay = thedelay / PACKETNUMBER;
			System.out.println("Throughput:" + throughput);
			System.out.println("Average delay:" + average_Delay);
			System.out.println("Total slots used from stations:" + PC.slots);
		}
		if (pc1.map_size() != 0 && pc2.map_size() == 0) {
			totalpacketsent = pc1.map_size();
			System.out.println("PC1 will broadcast:" + totalpacketsent + "packets");
			PC.slots = totalpacketsent;
			thedelay = (long) 0;
			throughput = (double) totalpacketsent / (double) PC.slots;
			average_Delay = thedelay / PACKETNUMBER;
			System.out.println("Throughput:" + throughput);
			System.out.println("Average delay:" + average_Delay);
			System.out.println("Total slots used from stations:" + PC.slots);
		}
		if (pc1.map_size() != 0 && pc2.map_size() != 0) {

			combine.compare_packet_list(pc1, pc2, pc1.map_size(), pc2.map_size());
			totalpacketsent = combine.TotalPacketsSent_AC();
			thedelay = Combiner.delaySum.longValue();
			average_Delay = thedelay / PACKETNUMBER;
			throughput = (double) totalpacketsent / (double) PC.slots;

			System.out.println("Throughput:" + throughput);
			System.out.println("Average delay:" + average_Delay);
			System.out.println("Total slots used from stations:" + PC.slots);
		}

		// System.out.println("Throughput:" + throughput);
		// System.out.println("Average delay:" +average_Delay);
		// System.out.println("Total slots used from stations:" + PC.slots);
		 
	}
	
	}


