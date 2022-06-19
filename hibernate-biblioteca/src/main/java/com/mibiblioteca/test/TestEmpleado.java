package com.mibiblioteca.test;

import  com.miblioteca.beans.*;

//import kenel.java.utilidades.HashSet;
//import kenel.java.utilidades.String;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 

      

public class TestEmpleado {

	private static EntityManager  manager ;
	
	private static EntityManagerFactory  emf;
	
public static  void MetodoHast() {	
    HashSet<String> hset =   new HashSet<String>();

   // Adding elements to the HashSet
   hset.add("Apple");
   hset.add("Mango");
   hset.add("Grapes");
   hset.add("Orange");
   hset.add("Fig");

   //Addition of duplicate elements
   hset.add("Apple ");
  // hset.add("Mango");

   //Addition of null values
   //hset.add(null);
   //hset.add(null);
   hset.add("Ultimo");
   //Displaying HashSet elements
   System.out.println(hset);
	}
	
	
	public static void main(String[] args) {
		
		/* Crear el Gestor de persistencia */
		System.out.println("  Linea cambiada desde github remoto" ) ;
		 MetodoHast();
		 
		emf =  Persistence.createEntityManagerFactory("GestionPersonal");
		try{

		manager = emf.createEntityManager();
		}catch (Exception e) {
			System.out.println(e.getMessage() );
			
		}	
		System.out.println("  voy a empezar la transaccion " ) ;

		Empleado   empleado = new Empleado( "Perez", "Garcia" , new GregorianCalendar(1985,6 , 6).getTime());
		Empleado   empleado2 = new Empleado( "Alberto", "Martinez" , new GregorianCalendar(1998,6 , 6).getTime());
		
		Direccion  direccion = new Direccion("Calle esteve grau", 80, 100);
		Direccion  direccion2 = new Direccion("Calle Pensamiento ", 3, 50, empleado);
			
		
		System.out.println("Fin1 ");	
	  //	managerList.saveItem(item); 
		try {	
 
		manager.getTransaction().begin();
		empleado.setDireccion(direccion);
		empleado2.setDireccion(direccion2);
		
	
	    manager.persist(empleado);
		manager.persist(empleado2);	

//		manager.persist(direccion);	
//		manager.persist(direccion);	
		
		
		//	manager.persist(item);
		/*		
		Empleado  e = manager.find(Empleado.class, 1L );
		System.out.println(" manager.find Nombre   1l " + e.getNombre()) ;
		e.setNombre(" Colchones");
			 */			
 
		 
		  }catch ( RuntimeException e) { System.out.println( "Error ");
		  System.out.println(e.getMessage() );
		  
		  }
		 
		List<Empleado>   listaEmpleado =  (List<Empleado>)manager.createQuery("FROM Empleado").getResultList();
	 
		System.out.println(" ********* Bucle de Salida ********" );
			
		for ( Empleado  empl : listaEmpleado ) {
			
			System.out.println(" nombre "+ empl.getCodigo()  + "," + empl.getNombre() + "," + empl.getApellidos()   	);
			
			
		}
		
		
		 
		
		
		manager.getTransaction().commit();
		
		
		
		
	System.out.println("*** FIN *****");
	
	 
	}
	
	
}
