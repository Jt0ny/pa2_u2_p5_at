package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;


@SpringBootApplication
public class Pa2U2P5AtApplication implements CommandLineRunner{
	
	@Autowired
	private IHabitacionService habitacionService;
	
	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Hotel hotel= new Hotel();
		hotel.setDireccion("Sangolqui");
		hotel.setNombre("Risol");
		
		Hotel hotel1= new Hotel();
		hotel1.setDireccion("Sangolqui");
		hotel1.setNombre("DAA");
		this.hotelService.guardarHotel(hotel1);
		
		Habitacion h1= new Habitacion();
		h1.setClase("Normal");
		h1.setNumero("A1");
		h1.setHotel(hotel);
		
		Habitacion h2= new Habitacion();
		h2.setClase("Premium");
		h2.setNumero("A2");
		h2.setHotel(hotel);

		List<Habitacion>habitaciones=new ArrayList<>();
		habitaciones.add(h1);
		habitaciones.add(h2);
		
		//INSERTAR
		System.out.println("INSERTAR");
		hotel.setHabitaciones(habitaciones);
		this.hotelService.guardarHotel(hotel);
		
		//ACTUALIZAR 
		System.out.println("ACTUALIZAR");
		hotel.setDireccion("Quito");
		this.hotelService.actualizar(hotel);
		
		h1.setNumero("A7");
		this.habitacionService.actualizar(h2);
		
		//BUSCAR
		System.out.println("BUSCAR");
		
		Hotel h01=this.hotelService.buscarPorId(1);
		System.out.println(h01);
		
		Habitacion ha1=this.habitacionService.buscarPorId(1);
		System.out.println(ha1);
		
		//ELIMINAR
		
		System.out.println("Eliminar");
		//this.habitacionService.eliminar();
		 
		
		
		
		

	
		
	}

}
