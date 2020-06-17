package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	@Id
	@Column(name= "c_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer c_usuario;

	@Column(name="nombre")
	@Size(max= 50, message = "El nombre no debe tener mas de 50 caracteres")
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String nombre;
	
	@Column(name= "apellido")
	@Size(max= 50, message = "El apellido no debe tener mas de 50 caracteres")
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String apellido;
	
	@Column(name= "carne")
	@Size(max= 10, message = "El carne no debe tener mas de 10 caracteres")
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String carne;
	
	@Column(name= "carrera")
	@Size(max= 100, message = "El nombre de la carrera no debe tener mas de 100 caracteres")
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String carrera;
	
	public Estudiante() {
		
	}

	public Integer getC_usuario() {
		return c_usuario;
	}

	public void setC_usuario(Integer c_usuario) {
		this.c_usuario = c_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	

}
