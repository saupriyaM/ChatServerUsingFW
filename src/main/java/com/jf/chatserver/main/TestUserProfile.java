package com.jf.chatserver.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jf.chatserver.dao.UserProfile;

public class TestUserProfile {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		UserProfile up = new UserProfile();
		up.setBirthDate((new SimpleDateFormat("yyyy-MM-dd")).parse("2010-12-21"));
		up.setCellPh("+919821464546");
		up.setResPh("+9102512494957");
		up.setWorkPh("+91226666666");
		up.setUserName("Snigdha Marathe");
		up.setNickName("snigu");
		up.setPassword("snigu@123");
		up.setMale(false);
		up.getEmailIds().add("supriya@gmail.com");
		up.getEmailIds().add("snigdha@gmail.com");
		up.getEmailIds().add("mugdha@gmail.com");
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(up);
		session.getTransaction().commit();
		session.close();
		
		Session getSession = sessionFactory.openSession();
		UserProfile up_temp = (UserProfile) getSession.get(UserProfile.class, 1);		
		
		sessionFactory.openStatelessSession().delete(up_temp);
	}

}
