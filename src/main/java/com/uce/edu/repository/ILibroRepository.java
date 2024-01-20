package com.uce.edu.repository;

import java.time.LocalDate;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroRepository {
	
	public void insertar (Libro libro);
	
	public void insertar2 (Libro2 libro2);
	
	public void actualizar(Libro libro);
	
	public Libro seleccionar (Integer id);
	
	public void borrar ( Integer id);
	
	//Query
	public Libro seleccionarPorNombre(String titulo);
	public List<Libro>seleccionarPorFechaPublicacion(LocalDate fechaPublicacion);
	
	//typed
	public Libro seleccionarPorTitulo(String titulo);
	public List<Libro>seleccionarPorFecha(LocalDate fechaPublicacion);

	//NamedQuery
	public Libro seleccionarPorTituloNamed(String titulo);
	public List<Libro>seleccionarPorFechaNamed(LocalDate fechaPublicacion);
	
	
	//NativeQuery
	
	public Libro encontrarPorTitulo(String  titulo);
	
	public List<Libro> encontrarPorEditorial(String editorial);
	
	public List<Libro> encontrarPorFechaPublicacion(LocalDate fechaPublicacion);
	
}
