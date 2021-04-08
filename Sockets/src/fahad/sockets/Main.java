package fahad.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class: Main 
 * Function: Working as initial thread, establishing all connections
 * 
 * @author Fahad
 *
 */
public class Main extends Thread {

	public static void main(String[] args) {

		try {
			ServerSocket sSocket = new ServerSocket(5000); // creating a server socket and allocating a port number
			ClientThread cThread = new ClientThread(); // creating the client thread
			cThread.start(); // starting client thread
			Socket sAccept = sSocket.accept(); // server socket accepts the connection request
			System.out.println("Connection Request Accepted!");
			// creating a reader, it will get the input stream from server socket
			BufferedReader read = new BufferedReader(new InputStreamReader(sAccept.getInputStream()));
			// creating a writer, it will get the output stream from server socket
			PrintWriter write = new PrintWriter(sAccept.getOutputStream());
			// passing the read and write to server thread
			ServerThread sThread = new ServerThread(read, write);
			sThread.start(); // starting server thread
			sSocket.close(); // closing server socket
			sleep(50); //waiting 50 milliseconds before printing the end message
			System.out.println("Initial thread ending."); //printing the ending of initial thread
			

		} catch (Exception e) // if there is any exception, catch it
		{
			e.printStackTrace();// print stack trace if any exception is found
		}

	}

}
