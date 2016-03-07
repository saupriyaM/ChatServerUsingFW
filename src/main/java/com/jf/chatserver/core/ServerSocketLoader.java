package com.jf.chatserver.core;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;

/**
 * Creates a SocketConnection. It will also help in balancing the socket load 
 * Once the socket channel is established, a new SocketConnection will be created.
 * A SocketConnectionList is maintained. This list will be used in getting the socketChannel for the receiver client.
 * @author admin
 *
 */
public class ServerSocketLoader {
	/**
	 * get the socket connection details from the list.
	 * key is sendername or a group name
	 */
	private HashMap<String, SocketConnection> socketConnectionList = new HashMap<String, SocketConnection>();
	private ApplicationContext appContext = ApplicationContextUtils.getApplicationContext();
	
	/**
	 * Create initial socket connection to listen
	 */
	public void init(){
		System.out.println("Creating First Socket Connection");
		createSocketConnection();
	}
	
	/**
	 * Event call received when Server connection is established.
	 * create a new ServerConnection for listening.
	 * Add the existing serverconnection to connectionList
	 * @param server
	 * @param name
	 */
	public void socketConnected(SocketConnection server, String name){		
		
		//add to socketConnectionList
		socketConnectionList.put(name, server);
		
		//create new ChatServer to accept next connection
		createSocketConnection();
	}
	
	private void createSocketConnection(){
		appContext.getBean("socketConnection");
	}
	
	public SocketConnection getSocketConnection(String name){
		return socketConnectionList.get(name);
	}
	
	/**
	 * Event call received when Server connection is disconnected.
	 * @param name
	 */
	public void socketDisconnected(String name){
		removeSocketConnection(name);
	}
	
	private void removeSocketConnection(String name){
		socketConnectionList.remove(name);
	}
	
	//load balancing methods go here
}
