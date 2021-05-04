package com.edf.ltihelloworld.service;

import java.util.List;

import com.edf.ltihelloworld.entity.Coche;



public interface ICocheService  {

	public List<Coche> listarTodos();
	
	public void guardar(Coche coche);
	public Coche buscarPorId(Long id);
	public void eliminar(Long id);
}
