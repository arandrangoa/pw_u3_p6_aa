package com.edu.uce.pw.api.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.edu.uce.pw.api.service.IEstudianteService;


@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteController {

	//Se inyecta la capa Service
	@Autowired
	private IEstudianteService estudianteService;


	//http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante est) {
//		Estudiante est= new Estudiante();
//		est.setNombre("Alex");
//		est.setApellido("Andrango");
//		est.setFechaNacimiento(LocalDateTime.of(1999,11,21,1,1));
		this.estudianteService.guardar(est);

	}

	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	@PutMapping(path = "/actualizar")
	public void actualizar(@RequestBody Estudiante est) {
//		Estudiante est=this.estudianteService.buscar(1);
//		est.setNombre("Ronaldo");
//		est.setApellido("Tuquerres");
//		est.setFechaNacimiento(LocalDateTime.of(1997,21,11,1,1));
		this.estudianteService.actualizar(est);

	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
	@PatchMapping(path = "/actualizar/parcial")
	public void actualizarParcial(@RequestBody Estudiante est){
		Estudiante est2=this.estudianteService.buscar(est.getId());
		if(est.getNombre()!=null) {
			est2.setNombre(est.getNombre());
		}
		if(est.getApellido()!=null) {
			est2.setApellido(est.getApellido());
		}
		if(est.getFechaNacimiento()!=null) {
			est2.setFechaNacimiento(est.getFechaNacimiento());
		}
		
		this.estudianteService.actualizar(est2);
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/1
	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		
		System.out.println("Borrar");
		this.estudianteService.borrar(id);

	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/1/nuevo/prueba
	@GetMapping(path = "/buscar/{id}/nuevo/{dato}")
	public Estudiante buscar(@PathVariable Integer id, @PathVariable String dato) {
		System.out.println("Dato:" +dato);
		return this.estudianteService.buscar(id);
	}
	
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarbuscarPorGenero?genero=F&edad=35
	@GetMapping(path="/buscarPorGenero")
	public List<Estudiante> buscarPorGenero(@RequestParam String genero, @RequestParam Integer edad){
		System.out.println("Edad: "+edad);
		List<Estudiante> lista=this.estudianteService.buscarPorGenero(genero);
		return lista;
		
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/2?prueba=HolaMundo
		@GetMapping(path = "/buscarMixto/{id}")
		public Estudiante buscarMixto(@PathVariable Integer id, @RequestParam String prueba) {
			System.out.println("ID:" +id);
			System.out.println("Prueba:" +prueba);
			return this.estudianteService.buscar(id);
			
		}
	
	
	


}