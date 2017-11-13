import java.util.Calendar;
import java.util.Random;

public class Station {
	
	double packetDuration=0;
	
	private long table[] ;
	private static final double PROBABILITY = 0.3;
	private static final double TRANSMISSION = 0.5;
	//private String name;
	private int ID ;
	int trasnpack;
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
	
public void PC(int num){
	if(PROBABILITY>random()){ //Growth ofSlot
		if(queue.empty() || queue.lenthgh()<5){
			packet.setId(num);
			queue.add();
			packetTimer.startTimer(); 
			
			}else{
				System.out.println("Full Queue");
			}
		
			//packetTimer.stopTimer();
			//System.out.println(queue);
			//packetDuration=packet.getDuration()+ packetTimer.getExecutionTime();
		//System.out.println(packetDuration);
					
		
		
	}
	else {System.out.println("Full Buffer");}
	
	}

	public void PCqueue(){
		queue.show();
	}
	
	
	public void transmission(int packNum){
		if(!queue.empty() ||TRANSMISSION == random()){
			queue.remove();	
			packetTimer.stopTimer();

			
			
			System.out.println("Time for packet\t"+ packNum+ ":" + packetTimer.getExecutionTime());
			packetTimer.resetTime();
		}
		else{
			System.out.println("No transmission was made");
		}
	}
	
	
	

			

}

	

