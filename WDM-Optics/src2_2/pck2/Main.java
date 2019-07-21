package pck2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 PC pc1= new PC();
		 PC pc2= new PC();
		Combiner combine= new Combiner();
		 
		 for(int f=0;f<13;f++) {
		
		 pc1.arrive_broadcast_In_Queue(f);
		 pc2.arrive_broadcast_In_Queue(f);
		 for(int j=0;j<(pc1.map_size()+1);j++) {
			 if(pc1.map_size()==0 && pc2.map_size()==0) {
				 System.out.println("Empty map");
			 }
			 if(pc1.map_size()==0 && pc2.map_size()!=0) {
				 System.out.println("Empty map1 not 2");
			 }
			 if(pc1.map_size()!=0 && pc2.map_size()==0) {
				 System.out.println("Empty map1 not 2");
			 }
			 else {
			 combine.compare_packet_list(pc1, pc2 ,j);
			 }
		 }
		 }
//		 System.out.println("So~");
		 
		
		 
	}

}
