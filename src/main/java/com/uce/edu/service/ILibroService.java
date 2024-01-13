package com.uce.edu.service;

import java.time.LocalDate;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {
	
	
	public void guardar (Libro libro);
	
	public void guardar2(Libro2 libro2);

	public void actualizar( Libro libro);
	
	public Libro buscar(Integer id);
	
	public void eliminar ( Integer id );
	
	public Libro buscarPorNombre(String titulo);
	
	public List<Libro>buscarPorFecha(LocalDate fechaPublicacion);

	//typed
	public Libro buscarPorTitulo(String titulo);
	public List<Libro>buscarPorFechaPubli(LocalDate fechaPublicacion);
	
	//NamedQuery
	public Libro buscarPorTituloNamed(String titulo);
	public List<Libro>buscarPorFechaNamed(LocalDate fechaPublicacion);
}
