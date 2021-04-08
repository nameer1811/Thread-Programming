package fahad.childthread4;
/**
 * Class: Main
 * Function: Using this class as initial thread to check on child thread
 * @author Fahad
 *
 */
public class Main extends Thread {
	
	public static void main(String[] args) {
		ThreadData data = new ThreadData(0); //setting counter to 0
		//creating child threads and naming the threads and putting the counter value in it
		ChildThread t1 = new ChildThread(data, "Thread 1");
		ChildThread t2 = new ChildThread(data, "Thread 2");
		ChildThread t3 = new ChildThread(data, "Thread 3");
		ChildThread t4 = new ChildThread(data, "Thread 4");
		
		//starting all the threads at the same time.
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		//Initializing a variable to calculate start time in seconds
		long startTime = (System.nanoTime()/1000000000);
		
		while(true) //using infinite loop
		{
			try {
				sleep(500); //initial thread sleeps for half a second
				//prints the counter value after every half a second
				System.out.println("Initial Thread: Counter value = " + data.getCounter());
				//when the value hits 40000
				if(data.getCounter() == 40000)
				{
					System.out.println("Success!!");
					break; //loop is broken
				}
				//if the current time subtracted by startTime is greater than 10
				if(((System.nanoTime()/1000000000)-startTime) > 10)
				{
					//then it will print a failure message
					System.out.println("Failure : System took too long to process!");
					break; //loop will be broken
				}
				
			} catch (InterruptedException IE) //if any exception is caught
			{
				System.out.println("Interruption detected: "+ IE.getMessage()); //sends a message
			}
		}
		//prints out that the thread is complete
		System.out.println("Initial thread is complete");
	}

}
