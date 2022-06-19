package com.mibiblioteca.codigo;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.miblioteca.beans.Item;
import com.miblioteca.beans.ItemList;

public class ManagerList {
		
	
	private static EntityManager  em  ;
	
	private static EntityManagerFactory  emf;
	
	
  public  void Inicio() {
	 
		emf =  Persistence.createEntityManagerFactory("GestionPersonal");
 

		em  = emf.createEntityManager();
}
	
	public void saveItem(Item item) {
//	    EntityManager em = EntityFactory.getEntityManager();       
        System.out.println("saliendo de saveItem");	
		try {
	        em.getTransaction().begin();      
	        em.persist(item);                      
	        em.getTransaction().commit();
	    } catch (EntityExistsException e) {
	        System.out.println(e);
	    } finally {
	        System.out.println("saliendo de saveItem");
	        em.close();
	    }
	}
	
	
	
	public void saveItemList(ItemList itemlist) {
//	    EntityManager em = EntityFactory.getEntityManager();
	    try {
	        em.getTransaction().begin();                           
	        em.merge(itemlist);
	        em.getTransaction().commit();
	    } catch (EntityExistsException e) {
	        System.out.println(e);
	    } finally {
	        em.close();
	    }
	}

	
	
	

}
