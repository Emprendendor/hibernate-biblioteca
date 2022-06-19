package com.miblioteca.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AUTOR")
public class Autor implements Serializable  {

	private static final long serialVersionUID = 131L;
	public long getId() {
		return id;
	}
	public void setId(long  id ) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public void setLibro( LibroEntity libro ) {
		
		librolista.add(libro);
		
	}
	

	@Id
	@Column(name = "IDAUTOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long   id;
	
	@Column(name = "NOMBRE")
	private  String  nombre;
	
	@Column(name = "APELLIDOS")
	private  String  Apellidos;
	
	public Autor () {
		
	}
	public Autor(long id, String nombre, String apellidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.Apellidos = apellidos;
	}
	
	public Autor(  String nombre, String apellidos) {
  
		this.nombre = nombre;
		this.Apellidos = apellidos;
	}
	
	@OneToMany( mappedBy = "autor" , cascade = CascadeType.ALL ) 
	private  List<LibroEntity>  librolista = new ArrayList<>();
		
	
	
	public List<LibroEntity> getLibrolista() {
		return librolista;
	}
	public void setLibrolista(List<LibroEntity> librolista) {
		this.librolista = librolista;
	}

	public void setLibroEntity( LibroEntity  libro) {
		this.librolista.add(libro) ;
	}



}
