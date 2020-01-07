package server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		final int SERVER_PORT = 5000;

		ServerSocket serverSocket = null;

		try {
			//server socket
			serverSocket = new ServerSocket();

			//bind server socket to server port
			String localHostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(localHostAddress, SERVER_PORT));
			System.out.println("[server] binding! \naddress:" + localHostAddress + ",port:" + SERVER_PORT);

			//client
			Socket socket = serverSocket.accept();

			InetSocketAddress remoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostName = remoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = remoteSocketAddress.getPort();

			System.out.println("[server] connected! \nconnected socket address:" + remoteHostName
					+ ", port:" + remoteHostPort);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
