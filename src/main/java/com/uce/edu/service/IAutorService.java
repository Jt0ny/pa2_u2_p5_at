package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Autor;

public interface IAutorService {
	
	public void guardar (Autor autor);
	
	public void actualizar ( Autor autor);
	
	public Autor buscar (Integer id);
	
	public void eliminar ( Integer id );
	
	//TypedQuery
	public List<Autor> buscarPorNacionalidad(String nacionalidad);
		
	public List<Autor> buscarPorGenero(String genero);
		
	public Autor buscarPorCedula(String cedula);
}
