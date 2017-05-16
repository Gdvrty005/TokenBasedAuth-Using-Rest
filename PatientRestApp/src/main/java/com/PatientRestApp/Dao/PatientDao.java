package com.PatientRestApp.Dao;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.PatientRestApp.Entity.Patients;
import com.PatientRestApp.Entity.Token;
import com.PatientRestApp.util.*;

public class PatientDao {
	
public  static Patients getPatientsById(int id){
		
		SessionFactory sessionFactory =  Hibernate.getSessionfactory();
		
	    Session session = sessionFactory.openSession();
	    
	   Patients patients = session.get(Patients.class, id);
	   
	   return patients;
	}

public static List<Patients> getAllPatients(){
	
    SessionFactory sessionFactory =  Hibernate.getSessionfactory();
	
    Session session = sessionFactory.openSession();
    
    Transaction transaction =session.getTransaction();
    
    transaction.begin();
    
    Query query = session.createQuery("from Patients");
    
    List<Patients> patients =  query.getResultList();
    
    return patients;
	
	
}
	public void saveToken(Token token){
		SessionFactory sessionFactory =  Hibernate.getSessionfactory();
		
	    Session session = sessionFactory.openSession();
	    
	    Transaction transaction =session.getTransaction();
	    
	    transaction.begin();
	    
	    session.saveOrUpdate(token);
	    
	    transaction.commit();
	    
	    
	    
	   }
	
	public static List<Token> getByToken(String token){
		
        SessionFactory sessionFactory =  Hibernate.getSessionfactory();
		
	    Session session = sessionFactory.openSession();
	    Query query =  session.createQuery("from Token where token = ?");
	    
	    query.setParameter(0, token);
	    System.out.println("2");
	    List<Token> token2 = query.getResultList();
	    return token2;
		
		
	}

}
