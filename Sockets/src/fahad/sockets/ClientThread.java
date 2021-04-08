package fahad.sockets;

import java.io.*;
import java.net.*;

/**
 * Class: ClientThread 
 * Function: Establishing connection, sending and receiving
 * message to and from server.
 * 
 * @author Fahad
 *
 */

public class ClientThread extends Thread {
	/**
	 * Method: Run 
	 * Function: Establishing connection, sending and receiving message
	 * to and from server.
	 */
	public void run() {
		try {
			sleep(1000); // pausing the thread for a second
			System.out.println("Client Thread Started!"); // printing that client thread started
			Socket clientSocket = new Socket("localhost", 5000); // creating client socket
			System.out.println("Client-side connection created!"); //printing that connection was created	
			// creating a reader for the stream from the connection
			BufferedReader read = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			// creating a writer for the stream from the connection
			PrintWriter write = new PrintWriter(clientSocket.getOutputStream());
			String message = read.readLine(); // reading first message sent
			System.out.println("Client received: " + message); // printing the message that client received
			write.write("1\n"); // writing the message
			write.flush(); // sending the message
			for (int i = 1; i <= 50; i++) {
				// initiating a count variable, it will read the line sent by the server
				// store it as an integer.
				Integer count = Integer.parseInt(read.readLine());
				System.out.println("Client received: " + count); // printing the count received from server
				count++; // incrementing count
				// if count is less than 100
				if (count < 100) {
					write.write(count + "\n"); // write the count
					write.flush(); // send the count
				}
			}
			write.write("End!\n"); // write an end message when everything is done
			write.flush(); // send the end message
			write.close(); // close writer
			read.close(); // close reader
			clientSocket.close();

		} catch (Exception e) // if there is any exception, catch it
		{

			e.printStackTrace(); // print stack trace if any exception is found
		}

	}
}
