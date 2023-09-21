package com.pagos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagos.service.PagosService;
import com.persistence_escuela.entity.Estudiantes;
import com.persistence_escuela.entity.Pagos;
import com.persistence_escuela.repository.EstudiantesRepository;
import com.persistence_escuela.repository.PagosRepository;
import com.persistence_escuela.request.PagosRequest;

@Service
public class PagosImplement implements PagosService{

	@Autowired
	PagosRepository repo;
	
	@Autowired
	EstudiantesRepository repoE;
	
	@Override
	public Pagos guardar(PagosRequest request) {
		Pagos p = new Pagos();
		Estudiantes e = repoE.findById(request.getEstudiante().getIdEstudiante()).get();
		//p.setEstudiante(request.getEstudiante());
		p.setEstudiante(e);
		p.setMonto(request.getMonto());
		p.setFecha(request.getFecha());
		p.setConcepto(request.getConcepto());
		
		repo.save(p);
		return p;
	}

	@Override
	public Pagos actualizar(PagosRequest request) {
		Pagos p = repo.findById(request.getIdPago()).get();
		Estudiantes e = repoE.findById(request.getEstudiante().getIdEstudiante()).get();
		p.setEstudiante(e);
		p.setMonto(request.getMonto());
		p.setFecha(request.getFecha());
		p.setConcepto(request.getConcepto());
		
		repo.save(p);
		return p;
	}

	@Override
	public Pagos buscar(int id) {
		return repo.findById(id).get();
	}

	@Override
	public String eliminar(int id) {
		repo.deleteById(id);
		return "Borrado";
	}

	@Override
	public List mostrar() {	
		return repo.findAll();
	}

}
