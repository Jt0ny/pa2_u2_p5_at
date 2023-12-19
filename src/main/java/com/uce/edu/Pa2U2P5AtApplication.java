package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5AtApplication implements CommandLineRunner{
	
	@Autowired
	private IEmpleadoService empleadoService;

	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Ciudadano c1= new Ciudadano();
		c1.setNombre("Anthony");
		c1.setApellido("Tipan");
		//this.ciudadanoService.guardar(c1);
		
		Ciudadano c2=this.ciudadanoService.buscarPorID(1);
		System.out.println(c2);
		
		Empleado e1= new Empleado();
		e1.setFechaIngreso(LocalDate.now());
		e1.setSalario(new BigDecimal(450));
		e1.setCiudadano(c2);
		this.empleadoService.guardar(e1);
		
	
		
	}

}
