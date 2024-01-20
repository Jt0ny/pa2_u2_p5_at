package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Autor;

public interface IAutorRepository {
	
	public void insertar (Autor autor);
	
	public void actualizar(Autor autor);
	
	public Autor seleccionar (Integer id);
	
	public void borrar ( Integer id);
	
	//TypedQuery
	public List<Autor> seleccionarPorNacionalidad(String nacionalidad);
	
	public List<Autor> seleccionarPorGenero(String genero);
	
	public Autor seleccionarPorCedula(String cedula);

}
