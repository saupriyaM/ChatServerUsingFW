package com.jf.chatserver.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketConnection{

	private int port;
	//private HashMap<String, ChatRoom> hmIdVsChatRoom;
	private static int counter;
	private ServerSocketLoader socketLoader = null;
	Socket socket = null; 
	public SocketConnection(ServerSocket serverSocket) {
		//this.hmIdVsChatRoom = new HashMap<String, ChatRoom>();
		try {
			socket = serverSocket.accept();
			System.out.println("Started listening on " + socket.getPort());
		} catch (IOException e) {			
			e.printStackTrace();
		}		

		//notify socketloader
		notifySocketLoader();
		initiateThreads();
	}


	private void notifySocketLoader(){
		socketLoader.socketConnected(this, "supriya");
	}

	public void initiateThreads() {
		Thread serviceTh = new Thread(new Conversation(), "Con-" + socket.getPort());
		serviceTh.start();
		System.out.println("Started Conversation thread");
	}

	class Conversation extends Thread
	{
		public Conversation()
		{

		}
		@Override
		public void run()
		{
			try
			{    
				while(true){
					BufferedReader nis = new BufferedReader(new InputStreamReader
							(socket.getInputStream()));
					String name = null;
					name = nis.readLine();
					System.out.println(name);

					//switch case for reading messages from socket
				}
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}

	}

}



