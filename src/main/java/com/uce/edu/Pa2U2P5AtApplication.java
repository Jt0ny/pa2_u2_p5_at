package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;

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
		
		
		//INSERTAR
		System.out.println("INSERTAR");
		Ciudadano c1= new Ciudadano();
		c1.setNombre("Anthony");
		c1.setApellido("Tipan");
		
		Empleado e1= new Empleado();
		e1.setFechaIngreso(LocalDate.now());
		e1.setSalario(new BigDecimal(450));
		
		e1.setCiudadano(c1);
		c1.setEmpleado(e1);
		
		this.ciudadanoService.guardar(c1);
		
		//ACTUALIZAR
		System.out.println("ACTUALIZAR");
		c1.setNombre("Joel");
		this.ciudadanoService.actualizar(c1);
		
		e1.setSalario(new BigDecimal(500));
		this.empleadoService.actualizar(e1);
		
		
		//BUSCAR
		System.out.println("BUSCAR");
		Ciudadano c2= this.ciudadanoService.buscarPorID(15);
		System.out.println(c2);
		Empleado e2=this.empleadoService.buscarPorId(19);
		System.out.println(e2);
		
		//ELIMINAR
		System.out.println("ELIMINAR");
		this.ciudadanoService.eliminar(7);
	//	this.empleadoService.eliminar(19);
		
		
		

	
		
	}

}
