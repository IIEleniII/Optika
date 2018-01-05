import java.util.Random;

//
//public class Main {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		 PC1 pc1= new PC1();
//		 PC pc= new PC();
//		 double probability;
//		for(int f=0;f<10;f++) {
//		
//		 pc1.arrive_broadcast_In_Queue(f);
//		 }
//	}
//
//}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double probability;
		int f = 0;
		int totalpacketsent = 0;
		random rand = new random();

		PC pc1 = new PC();
		PC pc2 = new PC();
		Long average_Delay;
		Combiner combine = new Combiner();
		// probability=rand.random();
		

		// 13packet sent

		for (f = 0; f < 13; f++) {
			probability = rand.random();
			System.out.println("PC1");
			if (probability > 0.3) {

				pc1.arrive_broadcast_In_Queue(probability);
				// pc2.arrive_broadcast_In_Queue(probability);
				// probability=random();
			}
		}

		for (f = 0; f < 13; f++) {
			probability = rand.random();
			System.out.println("PC2");
			if (probability > 0.3) {

				pc2.arrive_broadcast_In_Queue(probability);
				// probability=random();
			}
		}

		// for(int j=0;j<(pc1.map_size()+1);j++) {
		if (pc1.map_size() == 0 && pc2.map_size() == 0) {
			System.out.println("Empty maps.No broadcast from any PCS" + totalpacketsent);
			totalpacketsent = 0;
		}
		if (pc1.map_size() == 0 && pc2.map_size() != 0) {
			totalpacketsent = pc2.map_size();
			System.out.println("PC2 will broadcast:" + totalpacketsent + "packets");

		}
		if (pc1.map_size() != 0 && pc2.map_size() == 0) {
			totalpacketsent = pc1.map_size();
			System.out.println("PC1 will broadcast:" + totalpacketsent + "packets");

		}
		if (pc1.map_size() != 0 && pc2.map_size() != 0) {

			combine.compare_packet_list(pc1, pc2, pc1.map_size(), pc2.map_size());
			totalpacketsent = combine.TotalPacketsSent_AC();
		}

	}

}
