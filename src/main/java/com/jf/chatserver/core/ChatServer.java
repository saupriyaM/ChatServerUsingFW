package com.jf.chatserver.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.jf.chatserver.bo.ClientBO;
import com.jf.chatserver.chatroom.ChatRoom;

public class ChatServer{

	private int port;
	private HashMap<String, ChatRoom> hmIdVsChatRoom;
	private HashMap<String, ClientBO> hmNameVsClient;
	private static int counter;
	Socket socket = null; 
	public ChatServer(ServerSocket serverSocket) {
		try {
			socket = serverSocket.accept();
			System.out.println("Started listening on " + socket.getPort());
		} catch (IOException e) {			
			e.printStackTrace();
		}
		this.hmIdVsChatRoom = new HashMap<String, ChatRoom>();
		initiateThreads();
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
				BufferedReader nis = new BufferedReader(new InputStreamReader
						(socket.getInputStream()));
				String name = null;
				name = nis.readLine();

				//unique id needed
				if (hmNameVsClient.containsKey(name)) {
					name = "client" + counter;
					counter ++;
				}					
				ClientBO client = new ClientBO(name, socket);
				hmNameVsClient.put(name, client);
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}

	}
	
}



