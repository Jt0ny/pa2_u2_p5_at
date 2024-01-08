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
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ILibroService;


@SpringBootApplication
public class Pa2U2P5AtApplication implements CommandLineRunner{
	
	@Autowired
	private ILibroService iLibroService;
	
	@Autowired
	private IAutorService autorService;
	
	
	
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
		
		//Autor con varios libros
		
		Autor autor= new Autor();
		autor.setNacionalidad("Ecuatoriano");
		autor.setNombre("Jose");
		
		Libro libro1= new Libro();
		libro1.setFechaPublicacion(LocalDate.now());
		libro1.setTitulo("Mafalda");
		
		Libro libro2 = new Libro();
		libro2.setFechaPublicacion(LocalDate.now());
		libro2.setTitulo("Odisea");
		
		Set<Libro> libros2 = new HashSet<Libro>();
		libros2.add(libro1);
		libros2.add(libro1);
		
		autor.setLibros(libros2);
		
		Set<Autor> autores2=   new HashSet<Autor>();
		autores2.add(autor);
		
		libro1.setAutores(autores2);
		libro2.setAutores(autores2);
		
		this.autorService.guardar(autor);
		
		
	}

}
