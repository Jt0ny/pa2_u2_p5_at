package com.uce.edu.service;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {
	
	
	public void guardar (Libro libro);
	
	public void guardar2(Libro2 libro2);

	public void actualizar( Libro libro);
	
	public Libro buscar(Integer id);
	
	public void eliminar ( Integer id );
	
	public Libro buscarPorNombre(String titulo);
	
	}
