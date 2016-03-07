package com.jf.chatserver.core;

import java.net.Socket;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		try
        {
            AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring.cfg.xml");
            System.out.println("Server Signing started");
            List<ChatServer> chatServerList = (List<ChatServer>)ac.getBean("helper");

            System.out.println("Server Signing on11");
            for(ChatServer cs: chatServerList)
            {
            	System.out.println("Server Connection Established");	                
            }            
        }catch(Exception ex)
        {
          ex.printStackTrace();
        }
		
		
		
	}
}
