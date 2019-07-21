package pck2;

public class Combiner {
		//elegxos sugkrousewn packetwn
	//list pou 8a sugkrinontai 2 paketa th fora(an idia 0 an diaforetika 1)
	
//	public void put_in_list(PC pc) {
//		//edw mpainei to broadcast to PC
//	}
	//sugkrish 1 kai 2 keliwn
	public void compare_packet_list(PC pc1, PC pc2 , int key) {
		if(pc1.map_value(key)==pc2.map_value(key)) {
			pc1.map_remove(key);
			pc2.map_remove(key);
			System.out.println("There's been a collision");
		}
		else {
			System.out.println("continue");
		}
	

	}
	
	
	
	
}
