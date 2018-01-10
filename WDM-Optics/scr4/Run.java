import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Run
{
   public static void main(String[] args)throws IOException
    {
	   
	   File file1 =new File("C:\\Users\\trach\\.eclipse\\WDM\\src\\throughput.py");
	   File prob_file =new File("C:\\Users\\trach\\.eclipse\\WDM\\src\\probability.py");
		File file2 =new File("C:\\Users\\trach\\.eclipse\\WDM\\src\\AvgDelay.py");
		
		
	    FileWriter fw1=new FileWriter(file1.getAbsoluteFile());
	    FileWriter fw1a=new FileWriter(prob_file.getAbsoluteFile());
	   FileWriter fw2=new FileWriter(file2.getAbsoluteFile());
	    BufferedWriter bw1=new BufferedWriter(fw1);
	    BufferedWriter bw1a=new BufferedWriter(fw1a);
	    BufferedWriter bw2=new BufferedWriter(fw2);
		
		try {
			for (int i = 1; i <= 1000; i++) {
			Main.main(args);
			bw1.append(Main.returnThroughput()+"\n");
			bw1a.append(PC.prob+"\n");
			bw2.append(Main.returnAvgDelay()+"\n");}
		}catch(IOException e)
	{
		e.printStackTrace();
	}finally
	{
		if (bw1 != null && bw1a != null && bw2 != null  )
			try {
				bw1.close();
				bw1a.close();
				bw2.close();
			} catch (IOException ignore) {
			}

	}
	   
	   

     }
}