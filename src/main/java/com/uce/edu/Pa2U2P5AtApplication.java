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
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
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
		
		
		Libro2 l1=new Libro2();
		l1.setFechaPublicacion(LocalDate.now());
		l1.setTitulo("JAVA");
		
		
		Autor2 a1= new Autor2();
		a1.setNacionalidad("Chino");
		a1.setNombre("Roberto");
		
		Autor2 a2= new Autor2();
		a2.setNacionalidad("Argentino");
		a2.setNombre("Joel");
		
		List<Autor2> autores=   new ArrayList<Autor2>();
		autores.add(a1);
		autores.add(a2);
		
		AutorLibro autorLibro1=new AutorLibro();
		autorLibro1.setLibro2(l1);
		autorLibro1.setAutor2(a1);
		
		AutorLibro  autorLibro2= new AutorLibro();
		autorLibro2.setLibro2(l1);
		autorLibro2.setAutor2(a2);
		
		List<AutorLibro> autorLibros= new ArrayList<>();
		autorLibros.add(autorLibro1);
		autorLibros.add(autorLibro2);
		
		l1.setAutoresLibros(autorLibros);
	
		//this.iLibroService.guardar2(l1);
		
		Libro libro=this.iLibroService.buscarPorNombre("Mafalda");
		System.out.println(libro);
		
		
	}

}
