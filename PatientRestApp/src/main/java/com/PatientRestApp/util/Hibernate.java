package com.PatientRestApp.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.PatientRestApp.Entity.Patients;
import com.PatientRestApp.Entity.Token;

public class Hibernate {
	
	private static SessionFactory sessionfactory;
	
	static{
		
		Configuration configuration = new Configuration();
		
		//Load the xml for the details about the database 
		configuration.configure();
		
		//map the documents to the tables 
		configuration.addAnnotatedClass(Patients.class);
		configuration.addAnnotatedClass(Token.class);
		
		//
		
		ServiceRegistry serviceregistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		sessionfactory = configuration.buildSessionFactory(serviceregistry);
	}
	
	public static SessionFactory getSessionfactory() {
		return sessionfactory;
	}

}
