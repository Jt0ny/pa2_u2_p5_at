package com.uce.edu;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ILibroService;


@SpringBootApplication
public class Pa2U2P5AtApplication implements CommandLineRunner{
	
	@Autowired
	private ILibroService iLibroService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Libro l1=new Libro();
		l1.setFechaPublicacion(LocalDate.now());
		l1.setTitulo("JAVA");
		
		
		Autor a1= new Autor();
		a1.setNacionalidad("Chino");
		a1.setNombre("Roberto");
		
		Autor a2= new Autor();
		a2.setNacionalidad("Argentino");
		a2.setNombre("Joel");
		
		Set<Autor> autores=   new HashSet<Autor>();
		autores.add(a1);
		autores.add(a2);
		
		l1.setAutores(autores);
		
		Set<Libro> libros = new HashSet<Libro>();
		libros.add(l1);
	
		a1.setLibros(libros);
		a2.setLibros(libros);
		
		this.iLibroService.guardar(l1);
		
		
		
	}

}
