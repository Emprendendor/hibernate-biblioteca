package com.miblioteca.beans;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.miblioteca.beans.Direccion;
 
	@Entity
	@Table(name = "EMPLEADO")
	public class Empleado implements Serializable {

	public Long getCodigo() {
			return codigo;
		}
		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}
		public String getApellidos() {
			return apellidos;
		}
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Date getFechaNacimiento() {
			return fechaNacimiento;
		}
		public void setFechaNacimiento(Date fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@OneToOne( cascade = CascadeType.ALL )
	@JoinColumn(name ="ID_DIRECCION" )  
	private Direccion  direccion;
	
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Empleado(Long codigo, String apellidos, String nombre, Date fechaNacimiento) {
		super();
		this.codigo = codigo;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	public Empleado(String apellidos, String nombre, Date fechaNacimiento) {
		super();
	//	this.codigo = this.codigo;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
 
	public Empleado() {
	}

}
