package tryThread;

import java.io.FileWriter;
import java.io.IOException;

public class writeThread implements Runnable{
	int id=888888;
	String fileName="";
	String destination="D:/output1.txt";
	FileWriter writer=new FileWriter(destination);
	String line="";
	
	writeThread(String file) throws IOException
	{
		//fileName=file;
		writer=new FileWriter(file);
		
	}
	public void setLine(String line)
	{
		this.line=line;
		
	}
	
	public void run()
	{
		System.out.println("i'm writing thread"+id);
		try {
			write(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void write(String line) throws IOException 
	{
		//destination=des;
		//writer = new FileWriter(destination);
				
		writer.write(line);
	}
	public void close() throws IOException
	{
		
		writer.close();
	}

}
