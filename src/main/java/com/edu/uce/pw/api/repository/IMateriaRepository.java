package com.edu.uce.pw.api.repository;

import com.edu.uce.pw.api.repository.modelo.Materia;

public interface IMateriaRepository {
	
	Materia seleccionar(Integer id);
	void actualizar(Materia materia);
	void eliminar(Integer id);
	void insetar(Materia materia);
	
	
	
	

}
