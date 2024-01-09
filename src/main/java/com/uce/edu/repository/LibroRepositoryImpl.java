package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Libro libro) {
		this.entityManager.persist(libro);
		
	}

	@Override
	public void actualizar(Libro libro) {
		this.entityManager.merge(libro);
		
	}

	@Override
	public Libro seleccionar(Integer id) {
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void borrar(Integer id) {
		Libro libro= this.seleccionar(id);
		this.entityManager.remove(libro);
		
	}

	@Override
	public void insertar2(Libro2 libro2) {
		this.entityManager.persist(libro2);
		
	}

	@Override
	public Libro seleccionarPorNombre(String titulo) {
		//sql= Select * from libro l where l.libr_titulo=?
		//jpql= select l from Libro l where l.titulo=:variable
		Query query=this.entityManager.createQuery("Select l from Libro l where l.titulo=:variable");
		query.setParameter("variable", titulo);
		return (Libro) query.getSingleResult();
	}

}
