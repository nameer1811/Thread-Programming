package fahad.childthread4;
/**
 * Class: ThreadData
 * Function:Data object class
 * @author Fahad
 *
 */
public class ThreadData {
	
	//data member
	private volatile int counter;
	
	//constructor
	public ThreadData(int counter)
	{
		this.counter=counter;
	}
	
	//Increments the counter
	public synchronized void incrementCounter()
	{
		counter++;
	}
	
	//Setters and Getters
	public synchronized int getCounter()
	{
		return counter;
	}
	
	public synchronized void setCounter()
	{
		this.counter=counter;
	}

}
