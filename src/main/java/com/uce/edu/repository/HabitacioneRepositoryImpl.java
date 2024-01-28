package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacioneRepositoryImpl implements IHabitacioneRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Habitacion seleccionar(Integer id) {
	
		return this.entityManager.find(Habitacion.class,id);
	}

	@Override
	public void insertar(Habitacion habitacion) {
		this.entityManager.persist(habitacion);
		
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		this.entityManager.merge(habitacion);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(id);
		
	}

	@Override
	public List<Habitacion> seleccionarHabitacionPorNumero(String numero) {
		TypedQuery< Habitacion>query=this.entityManager.createQuery("select h from Habitacion h  inner join h.hotel ha where h.numero=:numero  ",Habitacion.class);
		query.setParameter("numero", numero);
		return query.getResultList();
		
	}

	@Override
	public List<Habitacion> seleccionarHabitacionPorClase(String clase) {
		TypedQuery< Habitacion>query=this.entityManager.createQuery("select h from Habitacion h  right join h.hotel ha where h.clase=:clase  ",Habitacion.class);
		query.setParameter("clase", clase);
		return query.getResultList();
	}

}
