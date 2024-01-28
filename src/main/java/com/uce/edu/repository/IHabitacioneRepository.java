package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Habitacion;

public interface IHabitacioneRepository {
	
	public Habitacion seleccionar (Integer id);
	
	public void insertar (Habitacion  habitacion);
	
	public void actualizar(Habitacion habitacion);
	
	public void eliminar (Integer id);
	
	// INNER JOIN
	public List<Habitacion> seleccionarHabitacionPorNumero(String numero);
	// RIGTH JOIN
	public List<Habitacion> seleccionarHabitacionPorClase(String clase);


}
