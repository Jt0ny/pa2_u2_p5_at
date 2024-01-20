package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEmpleadoRepository;
import com.uce.edu.repository.modelo.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private IEmpleadoRepository empleadoRepository;
	
	@Override
	public void guardar(Empleado empleado) {
		this.empleadoRepository.insertar(empleado);
		
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		
		return this.empleadoRepository.seleccionarPorId(id);
	}

	@Override
	public void actualizar(Empleado empleado) {
		this.empleadoRepository.actualizar(empleado);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.empleadoRepository.borrar(id);
	}

	@Override
	public List<Empleado> buscarPorFechaIngreso(LocalDate fechaIngreso) {
		
		return this.empleadoRepository.seleccionarPorFechaIngreso(fechaIngreso);
	}

	@Override
	public List<Empleado> buscarPorSalario(BigDecimal salario) {
		
		return this.empleadoRepository.seleccionarPorSalario(salario);
	}

	

}
