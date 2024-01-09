package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroRepository {
	
	public void insertar (Libro libro);
	
	public void insertar2 (Libro2 libro2);
	
	public void actualizar(Libro libro);
	
	public Libro seleccionar (Integer id);
	
	public void borrar ( Integer id);
	
	public Libro seleccionarPorNombre(String titulo);

}
