package com.uce.edu.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ILibroRepository;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

@Service
public class LibroServiceImpl implements ILibroService{

	@Autowired
	private ILibroRepository iLibroRepository;
	
	@Override
	public void guardar(Libro libro) {
		this.iLibroRepository.insertar(libro);
		
	}

	@Override
	public void actualizar(Libro libro) {
		this.iLibroRepository.actualizar(libro);
		
	}

	@Override
	public Libro buscar(Integer id) {
	
		return this.iLibroRepository.seleccionar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.iLibroRepository.borrar(id);
		
	}

	@Override
	public void guardar2(Libro2 libro2) {
	this.iLibroRepository.insertar2(libro2);
		
	}

	@Override
	public Libro buscarPorNombre(String titulo) {
	
		return this.iLibroRepository.seleccionarPorNombre(titulo);
	}

	@Override
	public List<Libro> buscarPorFecha(LocalDate fechaPublicacion) {
		
		return this.iLibroRepository.seleccionarPorFechaPublicacion(fechaPublicacion);
	}

	@Override
	public Libro buscarPorTitulo(String titulo) {
		
		return this.iLibroRepository.seleccionarPorTitulo(titulo);
	}

	@Override
	public List<Libro> buscarPorFechaPubli(LocalDate fechaPublicacion) {
		return this.iLibroRepository.seleccionarPorFecha(fechaPublicacion);
	}

	@Override
	public Libro buscarPorTituloNamed(String titulo) {
		return this.iLibroRepository.seleccionarPorTituloNamed(titulo);
	}

	@Override
	public List<Libro> buscarPorFechaNamed(LocalDate fechaPublicacion) {
		return this.iLibroRepository.seleccionarPorFechaNamed(fechaPublicacion);
	}

	//
	@Override
	public Libro seleccionarPorTitulo(String titulo) {
		
		return this.iLibroRepository.encontrarPorTitulo(titulo);
	}

	@Override
	public List<Libro> seleccionarPorEditorial(String editorial) {
		
		return this.iLibroRepository.encontrarPorEditorial(editorial);
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicacion(LocalDate fechaPublicacion) {
		
		return this.iLibroRepository.encontrarPorFechaPublicacion(fechaPublicacion);
	}

	

	
}
