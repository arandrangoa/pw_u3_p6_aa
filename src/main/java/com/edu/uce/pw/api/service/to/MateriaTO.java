package com.edu.uce.pw.api.service.to;

import java.io.Serializable;

public class MateriaTO implements Serializable {

	private static final long serialVersionUID = -8600035161157491314L;

	private Integer id;

	private String nombreMateria;
	private Integer numCreditos;
	private String profesor;
	private Integer numEstudiantes;
	
	//SET Y GET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreMateria() {
		return nombreMateria;
	}
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	public Integer getNumCreditos() {
		return numCreditos;
	}
	public void setNumCreditos(Integer numCreditos) {
		this.numCreditos = numCreditos;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public Integer getNumEstudiantes() {
		return numEstudiantes;
	}
	public void setNumEstudiantes(Integer numEstudiantes) {
		this.numEstudiantes = numEstudiantes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
