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
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private ILibroService iLibroService;
	@Autowired
	private IAutorService autorService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Autor a1= new Autor();
		a1.setCedula("123");
		a1.setGenero("Femenino");
		a1.setNacionalidad("Ecuatoriano");
		a1.setNombre("Luisa");
		Set<Autor> autores1=   new HashSet<Autor>();
		autores1.add(a1);
		
		Libro l1=new Libro();
		l1.setEditorial("Norma");
		l1.setFechaPublicacion(LocalDate.now());
		l1.setTitulo("Caperucita");
		Set<Libro> libros1=new HashSet<Libro>();
		libros1.add(l1);
		a1.setLibros(libros1);
		l1.setAutores(autores1);
		//this.iLibroService.guardar(l1);
		
		Autor a2=new Autor();
		a2.setCedula("456");
		a2.setGenero("Masculino");
		a2.setNacionalidad("Ecuatoriano");
		a2.setNombre("Juan");
		Set<Autor> autores2=   new HashSet<Autor>();
		autores2.add(a2);
	
		Libro l2=new Libro();
		l2.setEditorial("Norma");
		l2.setFechaPublicacion(LocalDate.now());
		l2.setTitulo("Homero");
		Set<Libro> libros2=new HashSet<Libro>();
		libros2.add(l2);
		a2.setLibros(libros2);
		l2.setAutores(autores2);
		//this.iLibroService.guardar(l2);
		
		System.out.println("TypedQuery");
		this.autorService.buscarPorNacionalidad("Ecuatoriano");
		this.autorService.buscarPorGenero("Masculino");
		this.autorService.buscarPorCedula("123");
		this.empleadoService.buscarPorFechaIngreso(LocalDate.of(2024, 01, 5));
		this.empleadoService.buscarPorSalario( new BigDecimal(500));
		
		System.out.println("NativeQuery");
		this.iLibroService.seleccionarPorTitulo("Homero");
		this.iLibroService.seleccionarPorFechaPublicacion(LocalDate.of(2024, 01, 5));
		this.iLibroService.seleccionarPorEditorial("Norma");
		this.ciudadanoService.buscarPorApellido("Tipan");
		this.ciudadanoService.buscarPorNombre("Joel");
		
		
		
	}

}
