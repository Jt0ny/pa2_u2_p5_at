package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAutorRepository;
import com.uce.edu.repository.modelo.Autor;

@Service
public class AutorServiceImpl implements IAutorService{
	
	@Autowired
	private IAutorRepository autorRepository;

	@Override
	public void guardar(Autor autor) {
		this.autorRepository.insertar(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		this.autorRepository.actualizar(autor);
	}

	@Override
	public Autor buscar(Integer id) {
		return this.autorRepository.seleccionar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.autorRepository.borrar(id);
		
	}

	@Override
	public List<Autor> buscarPorNacionalidad(String nacionalidad) {
		
		return this.autorRepository.seleccionarPorNacionalidad(nacionalidad);
	}

	@Override
	public List<Autor> buscarPorGenero(String genero) {
		
		return this.autorRepository.seleccionarPorGenero(genero);
	}

	@Override
	public Autor buscarPorCedula(String cedula) {
	
		return this.autorRepository.seleccionarPorCedula(cedula);
	}

	
}
