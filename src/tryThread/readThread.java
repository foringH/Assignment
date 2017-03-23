package tryThread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class readThread implements Runnable {
	int id=99999;
	String result="";
	File file;
	
	readThread(String fileName)
	{
		file=new File(fileName);
		
	}
	public String getResult()
	{
		
		return result;
	}
	public void run()
	{
		//System.out.println("i'm reading"+id);
		try {
			read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String read(File f) throws IOException
	{
		 if(f.isFile())
		 {
             FileReader fileReader= new FileReader(f);
             BufferedReader reader=new BufferedReader(fileReader);
             
             String line="";
             
             
             
             while ((line = reader.readLine()) != null) {
                 //System.out.println(line);
                 result=result+line;
                // System.out.println("rsult::::::"+result);
                // tryThread.writeThis=tryThread.writeThis+result;
               
             }
             reader.close();
             fileReader.close();
            // tryThread.writeThis=tryThread.writeThis+result;

         }
		
		return result;
	}


}
