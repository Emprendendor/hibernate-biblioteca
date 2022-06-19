package com.miblioteca.beans;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import javax.persistence.ManyToOne;

@Entity
@Table( name = "LIBROENTITY")

public class LibroEntity implements Serializable {

	private static final long serialVersionUID = 3123L;
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	
	@Id
	@Column(name = "ISBN")
	private String ISBN;
	@Column(name = "TITULO")
	private String Titulo;
	@Column(name = "CATEGORIA")
	private String Categoria;
		
	@ManyToOne(fetch= FetchType.LAZY )	  
	@JoinColumn(name = "IDAUTOR") 
	private Autor autor;
	
	
	public   LibroEntity(String ISBN ,String Titulo, String Categoria, Autor autor ) {
		this.autor = autor;
		this.ISBN  = ISBN;
		this.Titulo = Titulo ;
		this.Categoria = Categoria;
	}
	
	public   LibroEntity() {
	}
}


