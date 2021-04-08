package fahad.childthread;

/**
 * Class: ChildThread
 * Function: Incrementing the value of child thread by 1
 * 
 * @author Fahad
 *
 */
public class ChildThread extends Thread {

	// data member
	private ThreadData data;

	// constructor
	public ChildThread(ThreadData data) {
		this.data = data;
		System.out.println("Creating child " + data.getThreadName());
	}

	/**
	 * Method: Run 
	 * Function: Sleep for 1 second and then increase counter by 1
	 */
	public void run() {
		System.out.println("Running child " + data.getThreadName()); // printing the child thread name

		// using infinite loop
		while (true) {
			try {
				// printing the child thread name and value
				System.out.println("Child " + data.getThreadName() + " incrementing count with value " + data.getCounter());
				sleep(1000); // waiting for 1 second
				data.setCounter(); // increasing the counter
				// if counter hits 4
				if (data.getCounter() >= 4) {
					break;
				}

			} catch (InterruptedException e) // if there is an exception
			{
				// print the exception
				System.out.println("Child" + data.getThreadName() + "InterupptedException" + e.getMessage());
				break;
			}
		}
		// print after child thread is complete
		System.out.println("Child " + data.getThreadName() + " completed");
	}

}
