package pck2;

public class Packet {
	private int id;
	
	public Packet() {
		id=0;
	}
	
	public void set_id(int id) {
		this.id=id;
	}
	
	public int get_id() {
		return this.id;
	}
	
	public long start_timer() {
		long time_in ;
		return  time_in = System.nanoTime();}
	
	public long stop_timer() {
		long time_out;
		return time_out = System.nanoTime();
	}
	
	
}
