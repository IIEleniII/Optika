import java.util.*;
import java.util.Calendar;
import java.util.Random;
import java.util.Calendar;

public class Packet {

	private int id;
	private int arrival_time;
	private int duration=3;
	
	public void setDuration(int duration){
		this.duration = duration;
	}

	public int getDuration(){
		return duration;
	}

//	public void setArrival(int arrival_time){
//		this.arrival_time = arrival_time;
//	}
//
//	public int getArrival(){
//		return arrival_time;
//	}

	public void setId(int id){
		this.id=id;
	}

	public int getId(){
		return id;
	}
}

