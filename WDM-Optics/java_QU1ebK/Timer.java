import java.util.*;
import java.util.Calendar;
import java.util.Random;
import java.util.Calendar;

public class Timer {
	
	private long executionTime;
	
	public Timer(){
		this.executionTime = 0;
	}

	public void startTimer(){
		this.executionTime = System.nanoTime();
	}
	
  	public long startTimerOut(){
      	
		return this.executionTime;
	}
  
  
	public void stopTimer(){
		this.executionTime = System.nanoTime() - executionTime;
	}
	
	public void resetTime(){
		this.executionTime = 0;
	}
	
	//The executionTime value for the Timer object
	public long getExecutionTime(){
		return executionTime;
	}
	
	public String toString(){
		String timeDescription = "Current execution time is:"+ this.executionTime;
		
		return timeDescription;
	}


}

