package com.uce.edu.service;

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

}
