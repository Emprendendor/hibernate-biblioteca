package com.mibiblioteca.test;

import  com.miblioteca.beans.*;


import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


      

public class TestEmpleado {

	private static EntityManager  manager ;
	
	private static EntityManagerFactory  emf;
	
	
	public static void main(String[] args) {
		
		/* Crear el Gestor de persistencia */
		System.out.println("  Linea cambiada desde github remoto" ) ;

		 
		emf =  Persistence.createEntityManagerFactory("GestionPersonal");
		try{
			

		manager = emf.createEntityManager();
		}catch (Exception e) {
			System.out.println(e.getMessage() );
			
		}	
		System.out.println("  Inicio main 2" ) ;
		
		
		Empleado   empleado = new Empleado(70L, "andres", "escobar" , new GregorianCalendar(1979,6 , 6).getTime());
		Empleado   empleado2 = new Empleado(80L, "pedro", "Pescador" , new GregorianCalendar(1960,6 , 6).getTime());

		manager.getTransaction().begin();
		
		
	    manager.persist(empleado);
		manager.persist(empleado2);	
		
 
		List<Empleado>   listaEmpleado =  (List<Empleado>)manager.createQuery("FROM Empleado").getResultList();
	 
		System.out.println("  Bucle de entrada" );
			
		for ( Empleado  empl : listaEmpleado ) {
			
			System.out.println(" nombre "+ empl.toString());
			
			
		}
		manager.getTransaction().commit();
		
		
		
		
	System.out.println("*** FIN *****");
	
	 
	}
	
	
}
