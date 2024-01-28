package com.uce.edu.repository;

import java.util.List;


import com.uce.edu.repository.modelo.Hotel;

public interface IHotelRepository {
	
	public Hotel seleccionar (Integer id);
	
	public void insertar (Hotel  hotel);
	
	public void actualizar(Hotel hotel);
	
	public void eliminar (Integer id);
	
	//LEFT JOIN
	public List<Hotel> seleccionarHabitacionPorDireccion(String direccion);
	//Full JOIN
	public List<Hotel> seleccionarHabitacionPorNombre(String nombre);


}
