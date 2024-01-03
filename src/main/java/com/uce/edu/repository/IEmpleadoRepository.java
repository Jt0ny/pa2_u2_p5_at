package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoRepository {
	
	
	public void insertar (Empleado empleado );
	
	public Empleado seleccionarPorId (Integer id);

	public void actualizar(Empleado empleado);
	
	public void borrar(Integer id);
}
