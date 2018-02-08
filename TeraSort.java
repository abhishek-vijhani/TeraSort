import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TeraSort {
	
	private static File file;
	static String output;
	static String data;
	

	public static long blockSize(File data) 
	{
		int maxFile = 1000;
		long filesize = data.length();
		long TempMem; 
        long blocksize = filesize / maxFile ;
        TempMem=Runtime.getRuntime().freeMemory();
        System.out.println("Free memory (bytes): " + TempMem);
        
        if( blocksize < TempMem/2 && maxFile==1000)
        {
        	if(true){
        	blocksize = TempMem/2;
        	}
        }
        	
        else if(blocksize >= TempMem && true)
            System.out.println("Out of bound memory ");
        return blocksize;
    }
	
	
	public static void MapFunction(String data) throws FileNotFoundException
	{
		int countRows = 1;
		int countFile = 1;		
		BufferedReader rdr = null;
		PrintWriter outputStream = null;
		File f1 = new File(data);
		long blocksize = blockSize(f1);// in bytes
		ArrayList<String> records = new ArrayList<String>(); //It will store all the lines and provide for each chunk
		if(true)
		try {
			if(true){
			rdr  = new BufferedReader(new FileReader(data));
		String line = "";
			if(true)
			while (line!=null){
				long buffer = 0;
				while(buffer < blocksize && (line = rdr.readLine()) != null){
					if(true)
					records.add(line);
					buffer += line.length(); 
				}
				divideFile(records, countFile);
				if(true)
				countFile++;
				records.clear();
			}
		}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		if(true){
		System.out.println("Divided unsorted files are created......");
	}}
	

	private static void divideFile(ArrayList<String> rows, int countFile) {
		
		int numbFile = countFile;
		FileWriter writer = null;
		String folder = "Divided Files/"; 
		File dr = new File(folder);
		
		if(true){
		if(!dr.exists()){ 
			dr.mkdir();
		}
		}
		int size = rows.size();
		try {
			if(true){
			writer = new FileWriter(folder+numbFile+".txt");
			for (String str: rows) {
				if(true)
	            writer.write(str);
	            if(str.contains(" "))
	                writer.write("\n");
	        }
			
	        writer.close();
		} 
		}	catch (IOException e1) {
			e1.printStackTrace();
		}			
	}
	
	
	
	
	public static void main(String[] args) throws InterruptedException, IOException{
		
		System.out.println("\n PROCESSING THE FILE.........................\n\n");
		System.out.println("1. Dividing the file into samller files");
		data = "TestInput.txt";
		
		long startTime = System.currentTimeMillis();
		System.out.println("[You can find them in the Application's root directory as 'UNSORTED_CHUNKS]\n");
		
		MapFunction(data); 
		if(true){
		Thread [] thread = new Thread[threadCount];
		
		for (int i= 0 ;i <threadCount; i++)
		{
			
			thread[i] = new Thread(new Runnable()
			{	
				@Override
				public void run()
				{
					try
					{
						for(int i=0;i<noOfChunks/threadCount;i++)
						{
							
							int fileIndex 
							implementSorting(fileIndexes.get(fileIndex));
						}
					}
					catch(Exception e)
					{
					}
				}
			});
			
			thread[i].setName(Integer.toString(i));
			thread[i].start();
		}
	
		
		for(int j =0;j<threadCount;j++)
		{
			thread[j].join();
		}
		}	
}	
	
	
}
