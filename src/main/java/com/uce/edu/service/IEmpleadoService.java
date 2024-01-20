package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoService {
	
	public void guardar (Empleado empleado);
	
	public Empleado buscarPorId (Integer id);

	public void actualizar(Empleado empleado);
	
	public void eliminar(Integer id);
	
	//Native Query
	
	public List<Empleado> buscarPorFechaIngreso(LocalDate fechaIngreso);
	public List<Empleado> buscarPorSalario(BigDecimal salario);

}
