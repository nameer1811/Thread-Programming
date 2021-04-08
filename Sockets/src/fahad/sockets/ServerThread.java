package fahad.sockets;

import java.io.*;

/**
 * Class: ServerThread 
 * Function: Establishing connection, sending and receiving
 * message to and from client.
 * 
 * @author Fahad
 *
 */
public class ServerThread extends Thread {
	// data members
	private BufferedReader read;
	private PrintWriter write;

	// constructor
	protected ServerThread(BufferedReader read, PrintWriter write) {
		this.read = read;
		this.write = write;
	}

	/**
	 * Method: Run 
	 * Function: Establishing connection, sending and receiving message
	 * to and from client.
	 */
	public void run() {
		try {
			System.out.println("Server Thread Started!"); // printing that server thread started
			write.write("Authorized to GO!\n"); // writing message to notify client
			write.flush(); // sending the message
			while (true) {
				String message = read.readLine();// initiating a message variable to read the last line
				if (message.equals("End!")) // if message is equal to the last message
				{
					System.out.print("Server received: " + message + "\n"); // print the message
					write.close(); // close writer
					read.close(); // close reader
					break;
				} else {
					// initiating a count variable, it will read the message sent by the server
					// store it as an integer.
					Integer count = Integer.parseInt(message);
					System.out.println("Server received: " + count); // printing the count received from the client
					count++; // incrementing the count
					write.write(count + "\n"); // write the count
					write.flush(); // send the count
				}
			}
		} catch (Exception E) // if there is any exception, catch it
		{
			E.printStackTrace();// print stack trace if any exception is found

		}
	}

}
