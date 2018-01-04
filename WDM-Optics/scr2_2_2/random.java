import java.util.Random;

public class random {
	//Generates Random numbers
		public  double random(){
			
			double randomfloat=0;
		    
		    Random randomGenerator = new Random();
		    randomfloat = (float) (randomGenerator.nextFloat()*(1-0.1));
		    
			return randomfloat;
		}

}
