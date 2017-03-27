package Main;

//package threadReadWrite;

import java.io.File;
import java.io.IOException;

public class ThreadManager {
	
	private int numberOfFiles = 0;
	private String source = "";
	private String destination = "";
	private String result = "";
	
	private int numberOfThread = 0;
	private int numberOfSet = 0;
	private int fileNoInSet = 0;
	
	private File fileDirectory;
	private File[] fileList;
	
	private ReadThread[] readThreads;
	private Thread[] threads;
	private WriteThread writeThread;
	private Thread mainThread;
	
	private String writeContent = "";//"output e ase??";
	
	public ReadThread[] getReadThreads()
	{
		return readThreads;
		
	}
	
	public Thread[] getThreads()
	{
		return threads;
		
	}
	
	public String getWriteContent()
	{
		return writeContent;
		
	}
	
	public void setWriteContent(String line)
	{
		writeContent = writeContent + line;
		//System.out.println("HERES"+writeContent);
		
	}
	
	public void initialize(String source,String destination,int numOfThread) throws IOException
	{
		this.source=source;
		this.destination = destination;
		this.numberOfThread = numOfThread;
		this.numberOfSet = this.numberOfThread;
		
		this.fileDirectory = new File(source);
        this.fileList = this.fileDirectory.listFiles();
        this.numberOfFiles = fileList.length;
        System.out.println("printing n:" + numberOfFiles);
        
        if( this.fileList.length < this.numberOfThread )
        {
        	this.numberOfThread = this.fileList.length;
        	this.numberOfSet = this.numberOfThread;
        }
        
        this.fileNoInSet = (this.numberOfFiles/this.numberOfSet);
        
        writeThread=new WriteThread(this.destination);
		mainThread=new Thread(writeThread); 
        
		readThreads=new ReadThread[this.numberOfSet];
		threads=new Thread[this.numberOfSet];
				
	}
	
	public String read() throws InterruptedException
	{
		int index = 0;
		
	//	String result = "";
		
		for(int setNumber = 0; setNumber < numberOfSet; setNumber++)
		{
			if(setNumber < numberOfSet-1)
			{
				for( int fileNumber = 0; fileNumber < fileNoInSet; fileNumber++ )
				{
					index = ( fileNoInSet * setNumber ) + fileNumber;

					readThreads[setNumber] = new ReadThread(source+fileList[index].getName());
		        	threads[setNumber] = new Thread(readThreads[setNumber]);
		        	threads[setNumber].start();
					
		        	merge(setNumber);
		        	
		        	//System.out.println("I am here with1:" + result);
				}
				
			}
			else
			{
				index = index + 1;
				
				while(index < numberOfFiles)
				{					
					System.out.println("my set no:"+setNumber+" filrNo:"+index);
					
					readThreads[setNumber] = new ReadThread(source+fileList[index].getName());
		        	threads[setNumber] = new Thread(readThreads[setNumber]);
		        	threads[setNumber].start();
					
		        	
		        	merge(setNumber);
		        	
		        	//System.out.println("I am here with2:" + result);
		        	
		        	index++;
					
				}
				
			}			
			
		}
		
		return result;
	}
	
	public void merge(int setNo) throws InterruptedException
	{
		//String temp = "";
		
		threads[setNo].join();
    	
        result = result + readThreads[setNo].getResult();
	
		//return result;
		
	}
	
	public void write(String line)
	{
		String temp = "";
		temp = getWriteContent();
		
		//threadReadWrite.writeContent = threadReadWrite.writeContent+line;
		
		temp = temp + line;
		
		setWriteContent(temp);
		
    	this.writeThread.setLine(getWriteContent());
    	System.out.println("I want to write"+writeContent);
    	
		this.mainThread.start();
		
	}
	  
	

}

