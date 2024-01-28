package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.uce.edu.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Hotel seleccionar(Integer id) {
		
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void insertar(Hotel hotel) {
		this.entityManager.persist(hotel);
		
	}

	@Override
	public void actualizar(Hotel hotel) {
		this.entityManager.merge(hotel);
		
	}

	@Override
	public void eliminar(Integer id) {
		Hotel hotel= this.seleccionar(id);
		this.entityManager.remove(hotel);
		
	}

	@Override
	public List<Hotel> seleccionarHabitacionPorDireccion(String direccion) {
		TypedQuery< Hotel>query=this.entityManager.createQuery("select h from Hotel h Left join h.habitaciones ha where h.direccion=:direccion ",Hotel.class);
		query.setParameter("direccion", direccion);
		List<Hotel> lista =query.getResultList();
		
		for(Hotel h :lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHabitacionPorNombre(String nombre) {
		
		TypedQuery< Hotel>query=this.entityManager.createQuery("select h from Hotel h Full join h.habitaciones ha where h.nombre=:nombre ",Hotel.class);
		query.setParameter("nombre", nombre);
		List<Hotel> lista =query.getResultList();
		for(Hotel h :lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}
	

}
