package com.mibiblioteca.test;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.miblioteca.beans.Autor;
import com.miblioteca.beans.LibroEntity;
import java.util.*;
    public class TestAutoresLibros {

	private static EntityManagerFactory  emf;
	
	 
	 private static EntityManager  manager ;

 	public static void main(String[] args) {
			
	
	emf =  Persistence.createEntityManagerFactory("GestionPersonal");
	try{

		manager = emf.createEntityManager();
	
	}	catch (Exception e) {

		System.out.println(e.getMessage() );
		
	}	
	System.out.println("  voy a empezar la transaccion " ) ;
 
	Autor autor = new Autor ( "pablo ", "neruda "  );
	Autor autor1 = new Autor( "Andres ", "Escobar "  );
	Autor autor2 = new Autor( "Juan ramon ", "gimenez "  );
	Autor autor3 = new Autor( "boris ", "Jomnson"  );
	LibroEntity libroentity = new  LibroEntity( "ABCD"  ,"rimas y leyendas " , "Poesia", autor  );	
	LibroEntity libroentity2 = new  LibroEntity( "RRRERE"  ,"leyenda Beso " , "Poesia", autor  );
	
 
	LibroEntity libroentity3 = new  LibroEntity( "12334"  ,"BREXIT  " , "DESASTRES", autor3  );
	
	
	//	LibroEntity libroentity = new  LibroEntity( "ABCD"  ,"NUCNA TE RINDAS" , "AUTOAYUDA"  );
//	LibroEntity libroentity1 = new  LibroEntity( "RRRR"  ,"NUCNA TE RINDAS" , "AUTOAYUDA"  );
	
	try {	

	manager.getTransaction().begin();
		
		autor.setLibro(libroentity);
		autor.setLibro(libroentity2);
		autor3.setLibro(libroentity3);

		manager.persist(autor);	
 		manager.persist(autor2);	
		manager.persist(autor3);	

	//	manager.persist(libroentity);
	//	manager.persist(libroentity2);
//LibroEntity libroentity2 = new  LibroEntity( "ABCS"  ,"Te regalo un beso " , "Poesia", autor  );
//		LibroEntity libroentity3 = new  LibroEntity( "rwsd"  ,"Platero y Yo " , "Poesia", autor2  );
		//	manager.persist(libroentity);
		
		
	//	autor.setLibro(libroentity1);

		
		
 
	  }catch ( RuntimeException e) { 
	  
	  System.out.println( "Error ");
	  System.out.println(e.getMessage() );
	  
	  }
	
	
	manager.getTransaction().commit();
	System.out.println("  fin  la transaccion " ) ;
	
	
//*********************************************************************************************************	
//*********************************************************************************************************	
	
	manager.getTransaction().begin();
	
	Autor   autorlast =   manager.find(Autor.class, 3L);
	
	System.out.println( " Libros  de " +   autorlast.getApellidos() + "  " +  autorlast.getNombre() );
	  
	for ( LibroEntity  libro   : autorlast.getLibrolista() ) {
	
	  System.out.println( " libros  "   + libro.getISBN()  + " "  + libro.getCategoria() + " " + libro.getTitulo() + "  " )  ;
	}
	  
	  
	  
	manager.getTransaction().commit();
	manager.close();
	emf.close();
	
	
	
}
 	
 	
 	
}
