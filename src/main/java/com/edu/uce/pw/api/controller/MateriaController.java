package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
@RequestMapping(path = "/materias")
public class MateriaController {

    @Autowired
    private IMateriaService iMateriaService;

    @PostMapping(path = "/guardar")
    public ResponseEntity<Materia> guardar(@RequestBody Materia mat) {
        this.iMateriaService.guardar(mat);
        
		HttpHeaders cabeceraPost= new HttpHeaders();
		cabeceraPost.add("mensaje_201", "Corresponde a la inserción de un recurso");
		cabeceraPost.add("valor", "Materia ingresada con éxito");
		return new ResponseEntity<>(mat ,cabeceraPost,201); 

    }

    @PutMapping(path = "/actualizar")
    public ResponseEntity<Materia> actualizar(@RequestBody Materia mat) {
        this.iMateriaService.actualizar(mat);
        HttpHeaders cabeceraPatch= new HttpHeaders();
		cabeceraPatch.add("mensaje_239", "Corresponde a la actualización parcial de un recurso");
		cabeceraPatch.add("valor", "Materia actualizado parcialmente");
		//return ResponseEntity.status(239).body(est2);
		return new ResponseEntity<>(mat,cabeceraPatch,239);
    }

    @DeleteMapping(path = "/borrar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Integer id) {
        this.iMateriaService.borrar(id);
        
        HttpHeaders cabeceraDelete= new  HttpHeaders();
		cabeceraDelete.add("mensaje_240", "Corresponde a la eliminación del recurso");
		cabeceraDelete.add("valor", "Materia eliminada");
		return new ResponseEntity<>("Eliminado correctamente",cabeceraDelete,240);
    }

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
		HttpHeaders cabeceraPut= new  HttpHeaders();
		cabeceraPut.add("mensaje_240", "Corresponde a la eliminación del recurso");
		cabeceraPut.add("valor", "Estudiante eliminado");
		this.iMateriaService.actualizar(mat2);
		return new ResponseEntity<>(mat,cabeceraPut,239);
    }
    
	@GetMapping(path = "/{id}",produces="application/xml")
	public ResponseEntity<Materia> buscarPorId(@PathVariable Integer id) {
		// return ResponseEntity.status(236).body(this.estudianteService.buscar(id));
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta de un recurso");
		cabeceras.add("valor", "Materia encontrada");
		return new ResponseEntity<>(this.iMateriaService.buscar(id), cabeceras, 236);
	}
	
	
	
    
}