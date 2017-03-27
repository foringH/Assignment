package Main;


import java.io.IOException;

public class Main {

	
	public static void main(String args[]) throws InterruptedException, IOException{  
			
		String source = "D:/test2/";
		String destination = "D:/output2.txt";
		int threadNo = 5;
		
		RandomFileGenerate randomFiles = new RandomFileGenerate(source,100);
		
		ThreadManager manager = new ThreadManager();
		manager.initialize( source,destination,threadNo );
		
		//manager.read();
		
		String line = "";
		line = manager.read();
		//line = manager.merge();
		
		manager.write(line);
      
	}  
	

}
