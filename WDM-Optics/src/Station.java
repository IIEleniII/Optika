import java.util.Calendar;
import java.util.Random;

public class Station {
	
	double packetDuration=0;
	
	private int table[] ;
	//private static final double PROBABILITY = 0.5;
	//private String name;
	private int ID ,i=0;
	//private char wavelength; //ë1->a ë2->b etc
	Queue queue= new Queue();
	Timer packetTimer = new Timer();
	Packet packet=new Packet();
	
//	public  station(String name,int ID,char wavelength){
//		this.name=name;
//		this.ID=ID;
//		this.wavelength=wavelength;
//	}
	public  double random(){
		//int idx = 1;
		double randomfloat=0;
	    //while(idx<5){
	    Random randomGenerator = new Random();
	    randomfloat = (float) (randomGenerator.nextFloat()*(1-0.1));
	    //}
	    //idx++;
		return randomfloat;
	    		   
	  }
	
public void PC(){
	if(0.5>random()){
			while(!queue.empty() //&& i<2
					){
			packet.setId(i);
			queue.add(packet);
			packetTimer.startTimer();
			//packet.setArrival(Calendar.getInstance().get(Calendar.MILLISECOND));	
			//table[i]=packet.getArrival();
			}
			i++;
			packetTimer.stopTimer();
			packetDuration=packet.getDuration()+ packetTimer.getExecutionTime();
		System.out.println(packetDuration);
		}
		else {System.out.println("Full Buffer");}
	}
	
//public void iterateTable(){
//		for(i=0;i<2;i++){
//			System.out.println(table[i]);
//		}
//}

	

	
}
