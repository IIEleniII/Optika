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
		int f=0;
		random rand=new random();
		
		
		 PC pc1= new PC();
		 PC pc2= new PC();
		 Long average_Delay;
		Combiner combine= new Combiner();
		 //probability=rand.random();
		 
		 //13packet sent
		
		 for(f=0;f<13;f++) {
			 probability=rand.random();
				System.out.println("PC1");
			 if(probability>0.3) {
			
		 pc1.arrive_broadcast_In_Queue(probability);
		pc2.arrive_broadcast_In_Queue(probability);
		//probability=random();
		 }
		 }	

		 for(f=0;f<13;f++) {
			 probability=rand.random();
			 System.out.println("PC2");
			 if(probability>0.3) {
			
		
		pc2.arrive_broadcast_In_Queue(probability);
		//probability=random();
		 }
		 }
		 
		 for(int j=0;j<(pc1.map_size()+1);j++) {
			 if(pc1.map_size()==0 && pc2.map_size()==0) {
				 System.out.println("Empty maps.No broadcast from any PCS");
			 }
			 if(pc1.map_size()==0 && pc2.map_size()!=0) {
				 System.out.println("PC2 will broadcast:"+ pc2.map_size()+"packets");
				 
			 }
			 if(pc1.map_size()!=0 && pc2.map_size()==0) {
				 System.out.println("PC2 will broadcast:"+ pc1.map_size()+"packets");
				
			 }
			 if(pc1.map_size()!=0 && pc2.map_size()!=0) {
			 combine.compare_packet_list(pc1, pc2 ,j);
			 }
		 }
		
	
		 }
		 
		
		 
		 
		 
		 
		 
		 
		 
		 
//		 for(int j=0;j<(pc1.map_size()+1);j++) {
//			 if(pc1.map_size()==0 && pc2.map_size()==0) {
//				 System.out.println("Empty map");
//			 }
//			 if(pc1.map_size()==0 && pc2.map_size()!=0) {
//				 System.out.println("Empty is  map1 not 2.Map 2 is:"+ pc2.map_size());
//				 
//			 }
//			 if(pc1.map_size()!=0 && pc2.map_size()==0) {
//				 System.out.println("Empty is map2 not 1.Map 1 is:"+ pc1.map_size());
//				
//			 }
//			 if(pc1.map_size()!=0 && pc2.map_size()!=0) {
//			 combine.compare_packet_list(pc1, pc2 ,j);
//			 }
//		 }
		 //}
//		 System.out.println("So~");
		 
		
		 
	}


