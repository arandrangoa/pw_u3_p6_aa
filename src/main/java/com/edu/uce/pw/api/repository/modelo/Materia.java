package com.edu.uce.pw.api.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="materia")
public class Materia {
	
	@Id
	@GeneratedValue(generator ="seq_materia",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_materia", sequenceName ="seq_materia",allocationSize = 1)
	@Column(name="mate_id")
	private Integer id;
	
	@Column(name="mate_nombre_materia")
	private String nombreMateria;
	
	@Column(name="mate_num_creditos")
	private Integer numCreditos;
	
	@Column(name="mate_profesor")
	private String profesor;
	
	@Column(name="mate_num_estudiantes")
	private Integer numEstudiantes;
	
	@ManyToOne
	@JoinColumn(name="mate_id_estudiante")
	private Estudiante estudiante;
	
	
	//GET Y SET
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

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	

	
	

}
