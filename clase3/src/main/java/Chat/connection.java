package Chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class connection {

	private final int port = 2006;
	private final String ip = "127.0.0.1";
	protected String msg = "";

	protected PrintStream ps;
	protected Socket sockC;
	protected ServerSocket sockS;

	private InetAddress direction;
	protected DataOutputStream dosServer, dosClient;

	
	
	public connection(enumType type) throws UnknownHostException, IOException {
		ps = new PrintStream(System.out);

		direction = InetAddress.getByName(ip);
			
		switch (type) 
		{
		case server:
			sockS = new ServerSocket(this.port);
			sockC = new Socket();
			break;
		case client:
			sockC = new Socket(direction,port);
			break;
		}
	}
}

enum enumType {
	server, client

}
