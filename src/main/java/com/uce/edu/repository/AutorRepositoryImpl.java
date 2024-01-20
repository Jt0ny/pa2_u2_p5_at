package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Autor autor) {
		this.entityManager.persist(autor);
		
	}

	@Override
	public void actualizar(Autor autor) {
		 this.entityManager.merge(autor);
	}

	@Override
	public Autor seleccionar(Integer id) {
		return this.entityManager.find(Autor.class, id);
		
	}

	@Override
	public void borrar(Integer id) {
		Autor autor=this.seleccionar(id);
		this.entityManager.remove(autor);
		
	}

	//TypedQuery
	@Override
	public List<Autor> seleccionarPorNacionalidad(String nacionalidad) {
		TypedQuery<Autor> query=this.entityManager.createQuery("select a  from Autor a where a.nacionalidad=:nacionalidad",Autor.class);
		query.setParameter("nacionalidad", nacionalidad);
		return query.getResultList();
	}

	@Override
	public List<Autor> seleccionarPorGenero(String genero) {
		TypedQuery<Autor>query=this.entityManager.createQuery("select a from Autor a where a.genero=:genero",Autor.class);
		query.setParameter("genero", genero);
		return query.getResultList();
	}

	@Override
	public Autor seleccionarPorCedula(String cedula) {
		TypedQuery<Autor> query=this.entityManager.createQuery("select a from Autor a where a.cedula=:cedula",Autor.class);
		query.setParameter("cedula", cedula);
		return query.getSingleResult();
	}

}
