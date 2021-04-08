package fahad.childthread4;
/**
 * Class: ChildThread
 * Function: Incrementing child thread after 0.1 seconds after every 100 increment
 * @author Fahad
 *
 */
public class ChildThread extends Thread{

	//data members
	private ThreadData threadData;
	private String threadName;
	
	//constructor
	public ChildThread(ThreadData threadData, String threadName)
	{
		this.threadData=threadData;
		this.threadName=threadName;
		System.out.println("Creating Child "+ threadName);
	}
	/**
	 * Method: Run
	 * Function: Increments the counter after 0.1 seconds
	 */
	public void run()
	{
		System.out.println(threadName + " is now runnning."); //printing the thread name
		
		while(true) //using infinite loop
		{
			try //try block
			{
				for(int i=0; i<100; i++) //using for loop
				{
					for(int j=0; j<100;j++) //using for loop
					{
						threadData.incrementCounter(); //incrementing the counter
					}
					Thread.sleep(100); //thread is waiting for 0.1 seconds
				}
			}
			catch(InterruptedException IE) //catching exceptions
			{
				IE.printStackTrace(); //printing stacktrace if exception is found
			}
			System.out.println(threadName + " is complete incrementing by 10000"); //printing thread name when ending
			break; //breaking out of loop
		}
	}
}
