package fahad.childthread;
/**
 * Class: ThreadData
 * Function: Data object class
 * @author Fahad
 *
 */
public class ThreadData {
	
	//data members
	private Integer counter;
	private String threadName;
	
	//constructor
	public ThreadData (String threadName)
	{
		this.counter=0;
		this.threadName=threadName;
	}

	//Setters and Getters
	public Integer getCounter() {
		return counter;
	}

	public void setCounter() {
		 counter++;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

}
