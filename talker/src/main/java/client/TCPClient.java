package client;

import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient {

	private static final int SERVER_PORT = 5000;

	private static final String SERVER_IP = "133.137.9.63";

	public static void main(String[] args) {

		Socket socket = null;
		try {
			socket = new Socket();

			socket.connect(new InetSocketAddress(SERVER_IP ,SERVER_PORT));
		} catch (Exception e) {

			e.printStackTrace();
		}finally {

		}
	}
}
