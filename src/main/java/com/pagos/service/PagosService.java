package com.pagos.service;

import java.util.List;

import com.persistence_escuela.entity.Pagos;
import com.persistence_escuela.request.PagosRequest;

public interface PagosService {

	Pagos guardar (PagosRequest request);
	Pagos actualizar(PagosRequest request);
	Pagos buscar(int id);
	String eliminar(int id);
	List mostrar();
}
