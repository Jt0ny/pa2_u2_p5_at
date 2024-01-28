package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Hotel;

public interface IHotelService {
	
	public void guardarHotel(Hotel hotel);

	public Hotel buscarPorId (Integer id);

	public void actualizar(Hotel hotel);
	
	public void eliminar(Integer id);
	//
	public List<Hotel> buscarHabitacionPorDireccion(String direccion);
	//
	public List<Hotel> buscarHabitacionPorNombre(String nombre);


}
