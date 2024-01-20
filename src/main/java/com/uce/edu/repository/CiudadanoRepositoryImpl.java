package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl  implements ICiudadanoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Ciudadano ciudadano) {
		this.entityManager.persist(ciudadano);
		
	}

	@Override
	public Ciudadano seleccionar(Integer id) {
	return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		this.entityManager.merge(ciudadano);
		
	}

	@Override
	public void borrar(Integer id) {
		Ciudadano ciud= this.seleccionar(id);
		this.entityManager.remove(ciud);
		
	}

	@Override
	public Empleado seleccionarPorCedula(String cedula) {
		TypedQuery<Empleado>query=this.entityManager
		.createQuery("select e from Empleado e where e.ciudadano.cedula=:cedula",Empleado.class);
		query.setParameter("cedula", cedula);
		return query.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCedulaCiu(String cedula) {
		Query query= this.entityManager
		.createNativeQuery("select * from ciudadano c where c.ciud_cedula=:cedula",Ciudadano.class);
		query.setParameter("cedula", cedula);
		return (Ciudadano) query.getSingleResult();
	}

	//NativeQuery
	@Override
	public List<Ciudadano> seleccionarPorApellido(String apellido) {
		Query query=this.entityManager.createNativeQuery("select * from ciudadano  c where c.ciud_apellido=:apellido",Ciudadano.class);
		query.setParameter("apellido", apellido);
		return (List<Ciudadano>)query.getResultList();
	}

	@Override
	public List<Ciudadano> seleccionarPorNombre(String nombre) {
		Query query=this.entityManager.createNativeQuery("select * from ciudadano  c where c.ciud_nombre=:nombre",Ciudadano.class);
		query.setParameter("nombre", nombre);
		return (List<Ciudadano>)query.getResultList();
	}

}
