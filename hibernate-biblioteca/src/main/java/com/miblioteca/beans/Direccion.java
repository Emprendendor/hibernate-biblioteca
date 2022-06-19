package com.miblioteca.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name="DIRECCION")
public class Direccion implements Serializable {  
	private static final long serialVersionUID = 1L;
	
		public long getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(long id_direccion) {
		this.id_direccion = id_direccion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCiudad() {
		return ciudad;
	}
	public void setCiudad(int ciudad) {
		this.ciudad = ciudad;
	}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID_DIRECCION")
		private long   id_direccion;
		
		public Direccion(String direccion, int ciudad, int codpostal, Empleado empleado) {
	 
			this.direccion = direccion;
			this.ciudad = ciudad;
			this.codpostal = codpostal;
			this.empleado = empleado;
		}
		
		public Direccion(String direccion, int ciudad, int codpostal ) {
	 
			this.direccion = direccion;
			this.ciudad = ciudad;
			this.codpostal = codpostal;
 
		}
		@Column(name = "DIRECCION")
		private String  direccion;

		@Column(name = "CIUDAD")
		private int    ciudad;

		@Column(name = "CODPOSTAL")
		private int   codpostal;

		@OneToOne(mappedBy = "direccion",fetch =  FetchType.LAZY)
		private Empleado empleado;
		
	
public Direccion(){
}



}
