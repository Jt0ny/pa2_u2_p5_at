package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Autor;

public interface IAutorRepository {
	
	public void insertar (Autor autor);
	
	public void actualizar(Autor autor);
	
	public Autor seleccionar (Integer id);
	
	public void borrar ( Integer id);

}
