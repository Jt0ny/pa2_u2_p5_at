package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService{

	@Autowired
	private ICiudadanoRepository ciudadanoRepository;
	
	@Override
	public void guardar(Ciudadano ciudadano) {
		this.ciudadanoRepository.insertar(ciudadano);
		
	}

	@Override
	public Ciudadano buscarPorID(Integer id) {
	
		return this.ciudadanoRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		this.ciudadanoRepository.actualizar(ciudadano);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.ciudadanoRepository.borrar(id);
		
	}

	@Override
	public Empleado buscarPorCedula(String cedula) {
		return this.ciudadanoRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public Ciudadano buscarPorCedulaCiu(String cedula) {
	
		return this.ciudadanoRepository.seleccionarPorCedulaCiu(cedula);
	}

	@Override
	public List<Ciudadano> buscarPorApellido(String apellido) {
	
		return this.ciudadanoRepository.seleccionarPorApellido(apellido);
	}

	@Override
	public List<Ciudadano> buscarPorNombre(String nombre) {
		
		return this.ciudadanoRepository.seleccionarPorNombre(nombre);
	}

	@Override
	public Ciudadano buscarPorApellidoCAQ(String apellido) {
		
		return this.ciudadanoRepository.seleccionarPorApellidoCAQ(apellido);
	}

	@Override
	public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula) {
		
		return this.ciudadanoRepository.seleccionarPorCriteria(nombre, apellido, cedula);
	}

	@Override
	public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		
		return this.ciudadanoRepository.seleccionarPorCriteriaAndOr(nombre, apellido, cedula)
				;
	}

}
