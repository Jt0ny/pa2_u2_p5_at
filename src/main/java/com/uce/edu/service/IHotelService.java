package com.uce.edu.service;

import com.uce.edu.repository.modelo.Hotel;

public interface IHotelService {
	
	public void guardarHotel(Hotel hotel);

	public Hotel buscarPorId (Integer id);

	public void actualizar(Hotel hotel);
	
	public void eliminar(Integer id);


}
