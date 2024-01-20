package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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

	@Override
	public List<Empleado> seleccionarPorFechaIngreso(LocalDate fechaIngreso) {
		TypedQuery<Empleado> query=this.entityManager.createQuery("select e from Empleado e where e.fechaIngreso=:fecha",Empleado.class);
		query.setParameter("fecha", fechaIngreso);
		return query.getResultList();
	}

	@Override
	public List<Empleado> seleccionarPorSalario(BigDecimal salario) {
		TypedQuery<Empleado> query=this.entityManager.createQuery("select e from Empleado e where e.salario=:salario",Empleado.class);
		query.setParameter("salario", salario);
		return query.getResultList();
	}

	

}
