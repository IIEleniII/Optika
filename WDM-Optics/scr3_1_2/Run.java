import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Run
{
   public static void main(String[] args)throws IOException
    {
	   
	   File file1 =new File("D:\\trach\\eclipse_java_Auth\\WDM-Optics-2\\scr2_2\\throughput.json");
		File file2 =new File("D:\\trach\\eclipse_java_Auth\\WDM-Optics-2\\scr2_2\\average_delay.json");
	    FileWriter fw1=new FileWriter(file1.getAbsoluteFile());
	    FileWriter fw2=new FileWriter(file2.getAbsoluteFile());
	    BufferedWriter bw1=new BufferedWriter(fw1);
	    BufferedWriter bw2=new BufferedWriter(fw2);
		
		try {
			for (int i = 1; i <= 1000; i++) {
			Main.main(args);
			bw1.append(Main.returnThroughput()+"\n");
			bw2.append(Main.returnAvgDelay()+"\n");}
		}catch(IOException e)
	{
		e.printStackTrace();
	}finally
	{
		if (bw1 != null && bw2 != null)
			try {
				bw1.close();
				bw2.close();
			} catch (IOException ignore) {
			}

	}
	   
	   
//         for(int i=1; i<=10; i++)
//             Main.main(args); 
     }
}