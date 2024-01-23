package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {
	
	public void insertar (Ciudadano ciudadano );
	
	public Ciudadano seleccionar(Integer id );
	
	public void actualizar (Ciudadano ciudadano);
	
	public void borrar (Integer id);
	
	//
	public Empleado seleccionarPorCedula(String cedula);

	public Ciudadano seleccionarPorCedulaCiu(String cedula);
	
	//Native Query
	public List<Ciudadano> seleccionarPorApellido(String apellido);
	
	public  List<Ciudadano> seleccionarPorNombre(String nombre);
	//Criterial API query
	public Ciudadano seleccionarPorApellidoCAQ(String apellido);
	
	//funcionalidad cuando el ciudadano sea de pichincha busque por nombre
	//cuando se de chimborazo lo busque por apellido
	//cuando  no sea de ninguna de las 2 lo busque por cedula
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido,String cedula);
	
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);
}
