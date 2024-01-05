package com.uce.edu.service;

import com.uce.edu.repository.modelo.Habitacion;

public interface IHabitacionService {
	
	public void guardarHabitacion(Habitacion habitacion);

	public Habitacion buscarPorId (Integer id);

	public void actualizar(Habitacion habitacion);
	
	public void eliminar(Integer id);

}
