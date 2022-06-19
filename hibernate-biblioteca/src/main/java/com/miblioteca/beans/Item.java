package com.miblioteca.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 

  @Entity
  
  @Table( name = "ITEM") 
  
  public class Item implements Serializable{
  
  private static final long serialVersionUID = 3L;
  
  @Id 
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  
  @Column(name = "ID")
  private long id;
  
  private String name; 
  private String description; 
  private double price;
  
  
  //@ManyToOne(fetch= FetchType.LAZY )
  
  //@JoinColumn(name = "IDLISTA") 
  private ItemList lista;
  
  
  public Item(String name, String description, double price) {

	this.name =   name; 
  	this.description = description; 
  	this.price = price; 
   } 
  
  
  
  public Item(long   id1 ,String name, String description, double price) {
	  this.id = id1; 
	  this.name   = name; 
	  this.description = description; 
	  this.price = price; 
  }
  
  public Item() {
  
  
  }
  
  }
 
  