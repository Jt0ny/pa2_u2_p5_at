package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.ILibroService;


@SpringBootApplication
public class Pa2U2P5AtApplication implements CommandLineRunner{
	

	@Autowired
	private ICiudadanoService ciudadanoService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ciudadano ciudadano=this.ciudadanoService.buscarPorApellidoCAQ("JA");
		System.out.println(ciudadano);
		
		Ciudadano ciudadano2=this.ciudadanoService.buscarPorCriteria("Juan", "Valla", "1726787425");
		System.out.println(ciudadano2);
		
		Ciudadano ciudadano4=this.ciudadanoService.buscarPorCriteria("Juan", "Valla", "0526787425");
		System.out.println(ciudadano4);
		
		
		System.out.println("Critaria API Query AND OR");
		Ciudadano ciudadano3=this.ciudadanoService.buscarPorCriteriaAndOr("Juan", "Valla", "1726787425");
		System.out.println(ciudadano3);
		
	}

}
