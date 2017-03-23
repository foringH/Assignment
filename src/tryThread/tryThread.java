package tryThread;

import java.io.File;
import java.io.IOException;

public class tryThread {
	
	public static String writeThis="output e ase??";
	  
	public static void main(String args[]) throws InterruptedException, IOException{  
		
		int numberOfFiles=2;
		String source="D:/test/";
		String destination="D:/output2.txt";
		
	//	randomFileGenerate random=new randomFileGenerate(source,100);	
		
        File FileDirectory = new File(source);
        File[] fileList = FileDirectory.listFiles();
        numberOfFiles=fileList.length;
        System.out.println("printing n:"+numberOfFiles);
        
        readThread[] readThreads=new readThread[numberOfFiles];
		Thread[] threads=new Thread[numberOfFiles];
		writeThread writeThread1=new writeThread(destination);
		Thread mainThread=new Thread(writeThread1); 
        
        
       // int i=0;
       // for(File f:fileList)
        for(int i=0;i<numberOfFiles;i++)
        {
        	//System.out.println(i);
        	System.out.println("i:"+i+"  "+source+fileList[i].getName());
        	readThreads[i] = new readThread(source+fileList[i].getName());
        	threads[i]=new Thread(readThreads[i]);
        	threads[i].start();
        	//i++;
        }
        System.out.println("I'm here!!!!!");
        
        try{
        	String temp="";
        	for(int j=0;j<numberOfFiles;j++)
        	{
        		
        		threads[j].join();
        		temp=temp+readThreads[j].getResult();   //result;
    			System.out.println("the temp is:"+temp);
    			
    			//tryThread.writeThis=tryThread.writeThis+temp;
    			//System.out.println("I want to write"+writeThis);
    			//writeThread1.line=tryThread.writeThis;
        		
        	}
        	
        	writeThread1.setLine(tryThread.writeThis+temp);
        	//writeThread1.line=tryThread.writeThis+temp;
        	System.out.println("I want to write"+writeThis);
        }
        catch(Exception e){
        	
        	System.out.println(e);
        }
        
        
        mainThread.start();
        try{
        	
        	//mainThread.join();
        	System.out.println("THE END!!!!!!!!!!!!!!");
        }
        catch(Exception e)
        {
        	System.out.println("error in writing!!!!");
        	
        }
		
        
      
	}  

}
