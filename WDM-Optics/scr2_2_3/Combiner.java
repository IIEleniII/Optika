import java.util.Map.Entry;

public class Combiner {
		//elegxos sugkrousewn packetwn
	//list pou 8a sugkrinontai 2 paketa th fora(an idia 0 an diaforetika 1)
	
//	public void put_in_list(PC pc) {
//		//edw mpainei to broadcast to PC
//	}
	
	  int pc1PacketsLeft;
	  int pc2PacketsLeft;
	  static int totalpacketsentPc1;
	  static int totalpacketsentPc2;
	  int counter=0;
	
	//sugkrish 1 kai 2 keliwn
	public void compare_packet_list(PC pc1, PC pc2 , int pc1size, int pc2size) {
		//if(pc1.map_value(key)==pc2.map_value(key)) {
			System.out.println("PC1:Keys"+pc1.map_keySet()+"values:"+pc1.map_values());
			System.out.println("PC2:Keys"+pc2.map_keySet()+"values:"+pc2.map_values());
			
			//System.out.println("PC2:"+pc2.map_value(key));
		//	Boolean flag=compare(pc1,pc2);
			//if(flag==1) {
//			pc1.map_remove(key);
//			pc2.map_remove(key);
			
			compare(pc1,pc2);
			
			System.out.println("sIZE PC1"+pc1.map_size());
			System.out.println(counter);
			pc1PacketsLeft=pc1.map_size()-counter;
//			System.out.println("Total packet sent PC1:"+pc1PacketsLeft);
			pc2PacketsLeft=pc2.map_size()-counter;
//			System.out.println("Total packet sent PC1:"+pc2PacketsLeft);
//			System.out.println("PC1:Keys"+pc1.map_keySet()+"values:"+pc1.map_values());
//			System.out.println("PC2:Keys"+pc2.map_keySet()+"values:"+pc2.map_values());
			
//			totalpacketsentPc1=pc1size-pc1PacketsLeft;
//			System.out.println("Total packet sent PC1:"+totalpacketsentPc1);
//			totalpacketsentPc2=pc2size-pc2PacketsLeft;
			System.out.println("Total packet sent:"+(pc1PacketsLeft+pc2PacketsLeft));
			
//			System.out.println("PC1:"+pc1.map_value(key));
//			System.out.println("PC2:"+pc2.map_value(key));
		//}
//		else {
//			
//			System.out.println("continue");
//		}
	
	}

public void compare(PC pc1, PC pc2 ) {
	
		
	for (Integer entry2 : pc2.map_keySet() )
	{
		    
		for (Integer entry1 : pc1.map_keySet()  )  {
			
		
			    if(entry2.equals(entry1)) {
//			    //	System.out.println("Tou pc1 kai pc2 koina:"+entry1 +"kai"+entry2);
			    	System.out.println("There's been a collision");
//			    	//System.out.println(entry1.getKey()+"and pc2"+entry2.getKey());
//			    		//pc2.map_remove_all(entry2.getKey(),entry2.getValue());
//				    	//pc1.map_remove_all(entry1.getKey(),entry1.getValue());
						counter++;
//		//				pc1PacketsLeft=pc1.map_size();
////						System.out.println("size1 :"+pc1.map_size());
////						pc2PacketsLeft=pc2.map_size();
////						System.out.println("size2 :"+pc2.map_size());
//			    	
			    }
			    else {
		    	
			    	System.out.println("None same keys yet");
				}
			    }
			
			}
		}
	
	
//	public void compare(PC pc1, PC pc2 ) {
//		
//		for (Integer entry1 : pc1.map_keySet() ) {
//		    //System.out.println(entry1);
//			for (Integer entry2 : pc2.map_keySet() ) {
//			    if(!entry1.equals(entry2)) {
//			    	System.out.println("None same keys yet");
//			    }
//			    else {
////			    	System.out.println("Tou pc1 kai pc2 koina:"+entry1 +"kai"+entry2);
//			    	System.out.println("There's been a collision");
//				    	pc1.map_remove(entry1);
//						pc2.map_remove(entry2);
//						pc1PacketsLeft=pc1.map_size();
//						//System.out.println("size"+pc1.map_size());
//						pc2PacketsLeft=pc2.map_size();
//			    	
//				}
//			    }
//			
//			}
//		}
		
	//return 	pc1.map_keySet().equals(pc2.map_keySet());
	}
	
	
	

