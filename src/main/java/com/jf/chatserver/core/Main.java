package com.jf.chatserver.core;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		try
        {
            AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring.cfg.xml");
            System.out.println("Loading Server Socket Loader");            
            ServerSocketLoader ssLoader = (ServerSocketLoader)ac.getBean("ssloader");
            ssLoader.init();
            
            
        }catch(Exception ex)
        {
          ex.printStackTrace();
        }
		
		
		
	}
}
