package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadThread implements Runnable {
	
	//private int id=99999;
	private String result = "";
	private File file;
	
	ReadThread(String fileName)
	{
		this.file=new File(fileName);
		
	}
	
	public String getResult()
	{
		
		return result;
	}
	
	public void run()
	{
		//System.out.println("i'm reading"+id);
		
		try {
			
			read(this.file);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String read(File file) throws IOException
	{
		 if(file.isFile())
		 {
             FileReader fileReader= new FileReader(file);
             BufferedReader reader=new BufferedReader(fileReader);
             
             String line = "";
                         
             while ((line = reader.readLine()) != null) {
            	 
                System.out.println(line);
                 result=result+line;
                 System.out.println("rsult::::::"+result);
                 
             }
             
             reader.close();
             fileReader.close();
          
         }
		
		return result;
	}


}
