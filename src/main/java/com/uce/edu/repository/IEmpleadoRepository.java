package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.cglib.core.Local;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoRepository {
	
	
	public void insertar (Empleado empleado );
	
	public Empleado seleccionarPorId (Integer id);

	public void actualizar(Empleado empleado);
	
	public void borrar(Integer id);
	
	//TypedQuery
	
	public List<Empleado> seleccionarPorFechaIngreso(LocalDate fechaIngreso);
	public List<Empleado> seleccionarPorSalario(BigDecimal salario);
	
	
	}
