import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		Station station =new Station();
		Packet pack= new Packet();
		
		
		for(int i=0;i<6;i++){
			pack.setId(i);
			station.PC(pack.getId());
		}
		station.PCqueue();
		
		for(int j=0;j<5;j++){
			station.transmission(j);
		}
		
//		station.station("PC1",1,'a');
//		station.station("PC2",2,'a');
//		station.station("PC3",3,'b');
//		station.station("PC4",4,'b');
//		station.station("PC5",5,'c');
//		station.station("PC6",6,'c');
//		station.station("PC7",7,'d');
//		station.station("PC8",8,'d');
		
		
		
		
		
		//station.iterateTable();
		//System.out.println("number is:"+ );
		}
	}


