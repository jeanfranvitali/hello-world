package com.jfvi.myapp.helloworld.testtoremove;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jfvi.myapp.helloworld.entities.Message;
import com.jfvi.myapp.helloworld.entities.User;

public class MainTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");   
		
		EntityManager em = emf.createEntityManager();		
		EntityTransaction transac = em.getTransaction();
		transac.begin();
		// User nouvellePersonne = new User();
		// nouvellePersonne.setId(0);
		User nouvellePersonne = em.find(User.class, 1);
		
		
		Message newMessage = new Message();
		newMessage.setDate(new Date());
		newMessage.setImportant(true);
		newMessage.setContent("mon premier message");
		newMessage.setUserBean(nouvellePersonne);
		
		em.persist(newMessage);
		
		transac.commit();
		em.close();   
		emf.close();  
	}

}
