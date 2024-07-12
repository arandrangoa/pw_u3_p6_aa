package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IMateriaService;

@RestController
@RequestMapping(path="/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService iMateriaService;

	//http://localhost:8080/API/v1.0/Matricula/materias
	@PostMapping()
	public ResponseEntity<Materia> guardar(@RequestBody Materia mat) {
		this.iMateriaService.guardar(mat);
		return ResponseEntity.status(201).body(mat);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/materias/actualizar
	@PutMapping(path = "/{id}")
	public ResponseEntity<Materia> actualizar(@RequestBody Materia mat, @PathVariable Integer id) {
		mat.setId(id);
		this.iMateriaService.actualizar(mat);
		return ResponseEntity.status(238).body(mat);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/materias/actualizar/parcial
	@PatchMapping(path = "/{id}")
	public ResponseEntity<Materia> actualizarParcial(@RequestBody Materia mat, @PathVariable Integer id) {
		mat.setId(id);
		Materia mat2=this.iMateriaService.buscar(mat.getId());
		if(mat.getNombreMateria()!=null) {
			mat2.setNombreMateria(mat.getNombreMateria());
		}
		if(mat.getNumCreditos()!=null) {
			mat2.setNumCreditos(mat.getNumCreditos());
		}
		if(mat.getNumEstudiantes()!=null) {
			mat2.setNumEstudiantes(mat.getNumEstudiantes());
		}
		if(mat.getProfesor()!=null) {
			mat2.setProfesor(mat.getProfesor());
		}
		
		this.iMateriaService.actualizar(mat2);
		return ResponseEntity.status(239).body(mat2);
		
	}
	
	//http://localhost:8080/API/v1.0/Matricula/materias/borrar
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		this.iMateriaService.borrar(id);
		return ResponseEntity.status(240).body("Borrado");
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Materia> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.status(236).body(this.iMateriaService.buscar(id));
	}
	
	
	
}
