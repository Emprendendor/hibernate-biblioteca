package com.mibiblioteca.test;

import com.mibiblioteca.codigo.ManagerList;
import com.miblioteca.beans.Item;
 

import java.util.ArrayList;  


public class TestManagerList {
	
	public static void Lista() {

		ArrayList<String> cars = new ArrayList<String>(); // Create an ArrayList object
		 	cars.add("BMW");
		    cars.add("Ford");
		    cars.add("Mazda");
	}
	
	public static void main(String[] args) {
		
		Lista();
		ManagerList   managerList  = new ManagerList();
		
		managerList.Inicio();
		
	//	Item  item = new Item("lapices", "colores", 3.5);
		System.out.println("Fin1 ");	
	//	managerList.saveItem(item); 

		System.out.println("Fin2 ");
		
		
	}
	

	
	
	
	
}
