package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Empleado empleado) {
		this.entityManager.persist(empleado);
		
	}

	@Override
	public Empleado seleccionarPorId(Integer id) {
		
		return this.entityManager.find(Empleado.class, id);
	}

	@Override
	public void actualizar(Empleado empleado) {
		this.entityManager.merge(empleado);
		
	}

	@Override
	public void borrar(Integer id) {
		Empleado empl=this.seleccionarPorId(id);
		this.entityManager.remove(empl);
		
	}

	

}
