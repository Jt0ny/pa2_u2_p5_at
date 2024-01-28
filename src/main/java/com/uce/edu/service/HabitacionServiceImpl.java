package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHabitacioneRepository;
import com.uce.edu.repository.modelo.Habitacion;

@Service
public class HabitacionServiceImpl implements IHabitacionService{

	@Autowired
	private IHabitacioneRepository habitacioneRepository;
	
	@Override
	public void guardarHabitacion(Habitacion habitacion) {
		this.habitacioneRepository.insertar(habitacion);
		
	}

	@Override
	public Habitacion buscarPorId(Integer id) {
	
		return this.habitacioneRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		this.habitacioneRepository.actualizar(habitacion);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.habitacioneRepository.eliminar(id);
		
	}

	@Override
	public List<Habitacion> buscarHabitacionPorNumero(String numero) {
		
		return this.habitacioneRepository.seleccionarHabitacionPorNumero(numero);
	}

	@Override
	public List<Habitacion> buscarHabitacionPorClase(String clase) {
		
		return this.habitacioneRepository.seleccionarHabitacionPorClase(clase);
	}

}
