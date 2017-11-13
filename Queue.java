import java.util.*;

public class Queue {
	
	
	 int i=0;
	PriorityQueue<Integer> q= new PriorityQueue<Integer>();
	Packet p= new Packet();
	
	public Boolean empty(){
		return q.isEmpty();
	}
	
	//Put packet in queue
	public void add() {					
		
			//Add on list
		//
		q.offer(p.getId());
		
	//}i++;
		//System.out.println(q);
	}
	
	public void show(){
		System.out.println(q);
	}
	
	//Remove element with the highest priority from list
	public void remove() {	
		//while(!q.isEmpty()) || i<5)
				//{
			
		q.poll();
			//}
		//i++;
		
		
		//System.out.println(q);						
	}
	
	
	public int lenthgh(){
		int size=q.size();
		return size;
	}
}
