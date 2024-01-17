package com.uce.edu;

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
import com.uce.edu.service.ILibroService;


@SpringBootApplication
public class Pa2U2P5AtApplication implements CommandLineRunner{
	
	
	//1.Query(JPQL)
	//1.1 TypedQuery
	//1.2 NamedQuery
	
	//2.Native query(SQL puro) 
	//3.Criterial API Query
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 Empleado empleado=this.ciudadanoService.buscarPorCedula("123");
		 System.out.println(empleado);
		
		 
		Ciudadano ciudadano= this.ciudadanoService.buscarPorCedulaCiu("123");
		 System.out.println(ciudadano);
		
		
	}

}
