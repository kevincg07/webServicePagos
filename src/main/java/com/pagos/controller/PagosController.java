package com.pagos.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagos.impl.PagosImplement;
import com.persistence_escuela.entity.Pagos;
import com.persistence_escuela.request.PagosRequest;

@RestController
@RequestMapping("pagos/")
public class PagosController {

	@Autowired
	PagosImplement logic;
	
	@PostMapping
	ResponseEntity<Pagos> guardar(@RequestBody PagosRequest request){
		Pagos p = logic.guardar(request);
		return new ResponseEntity<Pagos>(p, HttpStatus.OK);
	}
	
	@PutMapping
	ResponseEntity<Pagos> actualizar(@RequestBody PagosRequest request){
		Pagos p = logic.actualizar(request);
		return new ResponseEntity<Pagos>(p, HttpStatus.OK);
	}
	
	@GetMapping("buscar-por-id/{id}")
	ResponseEntity<Pagos> buscar(@PathVariable int id){
		Pagos p = logic.buscar(id);
		return new ResponseEntity<Pagos>(p, HttpStatus.OK);
	}
	
	@DeleteMapping("eliminar/{id}")
	ResponseEntity<String> eliminar(@PathVariable int id){
		String m = logic.eliminar(id);
		return new ResponseEntity<String>(m, HttpStatus.OK);
	}
	
	@GetMapping
	ResponseEntity<List<Pagos>> mostrar(){
		List<Pagos> pagos = logic.mostrar();
		return new ResponseEntity<List<Pagos>>(pagos, HttpStatus.OK);
	}
	
}
