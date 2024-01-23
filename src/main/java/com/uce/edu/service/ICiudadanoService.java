package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {
	
	public void guardar(Ciudadano ciudadano);
	
	public Ciudadano buscarPorID(Integer id );
	
	public void actualizar (Ciudadano ciudadano);
	
	public void eliminar (Integer id);
	//
	public Empleado buscarPorCedula(String cedula);

	public Ciudadano buscarPorCedulaCiu(String cedula);
	
	//Native Query
	public List<Ciudadano> buscarPorApellido(String apellido);
		
	public  List<Ciudadano> buscarPorNombre(String nombre);
	
	//Criterial API query
	public Ciudadano buscarPorApellidoCAQ(String apellido);
	
	public Ciudadano buscarPorCriteria(String nombre, String apellido,String cedula) ;
		
	public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula);

}
