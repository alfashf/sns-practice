/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author uceeas1
 */
import java.io.*;
import java.net.*;

public class EchoServer {
	public static void main(String[] args) throws IOException {
		
    String command = null;
		
	ServerSocket serverSocket = null;
        System.out.println("EchoServer: Start......");
	try{	
		serverSocket = new ServerSocket(4444);
	}	catch (IOException e) {
		System.err.println("Could not listen on port: 4444.");
		System.exit(1);
	}
	
	Socket clientSocket = null;
	System.out.println("EchoServer: Waiting for Connection;");
	try{	
		clientSocket = serverSocket.accept();
	}	catch (IOException e) {
		System.err.println("Accept failed.");
		System.exit(1);
	}
	System.out.println("EchoServer: Got Connection;");
	
	PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	PrintWriter out1 = new PrintWriter(clientSocket.getOutputStream(), true);
	BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	String inputLine, outputLine;

	System.out.println("EchoServer: Waiting;");
	
	Fibonacci f = new Fibonacci();
	Sum s = new Sum();
	Cycle c = new Cycle();
	//ReturnFunction rf = new ReturnFunction();

	while ((inputLine = in.readLine()) != null ) {
		System.out.println("EchoServer: got:"+inputLine);
		outputLine = inputLine;
		//out.println(outputLine);
		
		if (outputLine.equals("bye"))
			break;
		else if (outputLine.equals("Get Counter")){
			if(command==null){
				System.out.println("Counter: "+f.getCounter());
				out.println("Next Value: "+f.getCounter());
			}
			else if(command.equals("fibonacci")){
				System.out.println("Counter: "+f.getCounter());
				out.println("Next Value: "+f.getCounter());
				}
			else if(command.equals("sum")){
				System.out.println("Counter: "+s.getCounter());
				out.println("Next Value: "+s.getCounter());
				}
			else if(command.equals("cycle")){
				System.out.println("Counter: "+f.getCounter());
				out.println("Next Value: "+f.getCounter());
				}
			else {
				System.out.println("Counter: "+f.getCounter());
				out.println("Next Value: "+f.getCounter());
				}
		}
		else if(outputLine.equals("Select Fibonacci")){
			command = "fibonacci";
			f.reset();
			f.getNext();
			System.out.println("Next Value: "+f.N);
			out.println("Next Value: "+f.N);
		}
		else if(outputLine.equals("Select Sum")){
			command = "sum";
			s.reset();
			s.getNext();
			System.out.println("Next value: "+s.N);
			out.println("Next Value: "+s.N);
		}
		else if(outputLine.equals("Select Cycle")){
			command = "cycle";
			c.reset();
			c.getNext();
			System.out.println("Next value: "+c.N);
			out.println("Next value: "+c.N);
		}
		else if(outputLine.equals("Get Next")){
			
			if(command==null){
			f.getNext();
			System.out.println("Next value: "+f.N);
			out1.println("Next value: "+f.N);	
			} //end if
			
			else if(command.equals("fibonacci")){
			f.getNext();
			System.out.println("Next Value: "+f.N);
			out.println("Next Value: "+f.N);
			} //end if
			
			else if(command.equals("sum")){
			s.getNext();
			System.out.println("Next Value: "+s.N);
			out.println("Next Value: "+s.N);
			} //end else if
			
			else if(command.equals("cycle")){
			c.getNext();
			System.out.println("Next Value: "+c.N);
			out.println("Next Value: "+c.N);
			} //end else if
						
			else
			out.println(outputLine);			
		}//end else if
		
		else if(outputLine.equals("Reset")){			
			f.reset();
			s.reset();
			c.reset();
			out.println("All values have been reset");
			System.out.println("All values have been reset");
		}//end else if
		
		else
			out.println(outputLine);
		
	}//end while
	
	System.out.println("EchoServer: Closing Sockets.");

	out.close();
	in.close();
	clientSocket.close();
	serverSocket.close();
	System.out.println("EchoServer: End.");
}
}
