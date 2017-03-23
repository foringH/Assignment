package tryThread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class randomFileGenerate {
	String destination="D:/new/"; 
	
	randomFileGenerate(String des,int number) throws IOException
	{
		if(des.isEmpty()!=true)
		{
			//System.out.println("null");
			destination=des;
		}
		else
		{
			System.out.println("NOT   NULL");
			
		}
		for(int i=0;i<number;i++)
		{
			File curFile=new File(destination+"rand"+i+".txt");
			FileWriter writer=new FileWriter(curFile);
			String uuid = UUID.randomUUID().toString();
			//System.out.println("uuid = " + uuid);
			writer.write(uuid);
			writer.close();
			
		}

		
	}
	
}
