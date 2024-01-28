package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHotelRepository;
import com.uce.edu.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{

	@Autowired
	private IHotelRepository hotelRepository;
	
	@Override
	public void guardarHotel(Hotel hotel) {
		this.hotelRepository.insertar(hotel);
		
	}

	@Override
	public Hotel buscarPorId(Integer id) {
		
		return this.hotelRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Hotel hotel) {
		this.hotelRepository.actualizar(hotel);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.hotelRepository.eliminar(id);
		
	}

	@Override
	public List<Hotel> buscarHabitacionPorDireccion(String direccion) {
		
		return this.hotelRepository.seleccionarHabitacionPorDireccion(direccion);
	}

	@Override
	public List<Hotel> buscarHabitacionPorNombre(String nombre) {
		
		return this.hotelRepository.seleccionarHabitacionPorNombre(nombre);
	}

}
