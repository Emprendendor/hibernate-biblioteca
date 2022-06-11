package com.miblioteca.beans;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 
	@Entity
	@Table(name = "EMPLEADO")
	public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name = "COD_EMPLEADO")
	private Long   codigo;
	 

	@Column(name = "APELLIDOS")
	private String apellidos;
	 
	
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, codigo, fechaNacimiento, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre);
	}
	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	public Empleado(Long codigo, String apellidos, String nombre, Date fechaNacimiento) {
		super();
		this.codigo = codigo;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	public Empleado() {
	}

}
