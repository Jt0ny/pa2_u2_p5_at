package com.uce.edu;

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
	
		System.out.println("Inner Join");
		
		List<Habitacion>lista=this.habitacionService.buscarHabitacionPorNumero("A2");
		
		for(Habitacion h:lista) {
			System.out.println(h);
		}
		
		System.out.println("Right Join");
		
		List<Habitacion>lista1=this.habitacionService.buscarHabitacionPorClase("Normal");
		
		for(Habitacion h1:lista1) {
			System.out.println(h1);
		}
		
		System.out.println("Left Join");
		
		List<Hotel>lista2=this.hotelService.buscarHabitacionPorDireccion("Quito");
		
		for(Hotel ho:lista2) {
			System.out.println(ho);
			for(Habitacion h:ho.getHabitaciones()) {
				System.out.println(h);
			}
		}
		
		System.out.println("Full Join");
		List<Hotel>lista3=this.hotelService.buscarHabitacionPorNombre("Risol");
		for(Hotel ho:lista3) {
			System.out.println(ho);
			for(Habitacion h:ho.getHabitaciones()) {
				System.out.println(h);
			}
		}
	
	}

}
