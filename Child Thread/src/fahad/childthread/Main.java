package fahad.childthread;

/**
 * Class: Main 
 * Function: This will act as a initial thread and check on child
 * threads every 0.5 secs
 * 
 * @author Fahad
 *
 */
public class Main extends Thread{

	public static void main(String[] args){
		double seconds = 0.5; // initializing seconds to keep track of time

		ThreadData thread1data = new ThreadData("Thread 1"); // creating ThreadData object
		ChildThread thread1 = new ChildThread(thread1data); // creating ChildThread object
		thread1.start(); // starting thread1

		// waiting 10 milliseconds to start thread 2
		try {
			sleep(10);
		} catch (InterruptedException e) {
			System.out.println("InterupptedException" + e.getMessage());
		}

		ThreadData thread2data = new ThreadData("Thread 2"); // creating ThreadData object
		ChildThread thread2 = new ChildThread(thread2data); // creating ChildThread object
		thread2.start(); // starting thread2

		// using infinite loop
		while (true) {
			try {

				sleep(500); // initial loop waiting for half a second
				System.out.println("\nInitial Thread having waited about " + seconds + " seconds");
				System.out.println("Initial Thread : Thread 1 Count = " + thread1data.getCounter() + ". Thread 2 Count = "
						+ thread2data.getCounter() + ".");
				seconds = seconds + 0.5;
				// if both the child threads is more than or equal to 4 then loop breaks
				if (thread1data.getCounter() >= 4 && thread2data.getCounter() >= 4) {
					break;
				}

			} catch (InterruptedException e1) {
				System.out.println("InterupptedException" + e1.getMessage());
				break;
			}

		}
		// prints that the threads ended.
		System.out.println("Both child threads terminated. Main thread ending.");

	}

}
