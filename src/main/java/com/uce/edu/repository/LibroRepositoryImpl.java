package com.uce.edu.repository;

import java.time.LocalDate;
import java.util.List;

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
	
	//Query
	
	@Override
	public Libro seleccionarPorNombre(String titulo) {
		//sql= Select * from libro l where l.libr_titulo=?
		//jpql= select l from Libro l where l.titulo=:variable
		Query query=this.entityManager.createQuery("Select l from Libro l where l.titulo=:variable");//SQL1
		query.setParameter("variable", titulo);
		return (Libro) query.getResultList().get(0);
		//return (Libro) query.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicacion(LocalDate fechaPublicacion) {
		//SQL: select * from libro l where l.libr_fecha_publicacion >=?
		//JPQL: select l from Libro l where l.fechaPublicacion >=:fecha
		Query myQuery= this.entityManager.createQuery("select l from Libro l where l.fechaPublicacion >=:fecha");
		myQuery.setParameter("fecha", fechaPublicacion);
		return (List<Libro>)myQuery.getResultList();
	}

	//TypedQuery
	@Override
	public Libro seleccionarPorTitulo(String titulo) {
		
		TypedQuery<Libro>query=this.entityManager.createQuery("Select l from Libro l where l.titulo=:titulo", Libro.class);
		query.setParameter("titulo", titulo);
		return query.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFecha(LocalDate fechaPublicacion) {
		TypedQuery<Libro> query=this.entityManager.createQuery("select l from Libro l where l.fechaPublicacion >=:fecha",Libro.class);
		query.setParameter("fecha", fechaPublicacion);
		return query.getResultList()
				;
	}

	//NamedQuery
	@Override
	public Libro seleccionarPorTituloNamed(String titulo) {
		TypedQuery<Libro>query=this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo",Libro.class);
		query.setParameter("titulo", titulo);
		return query.getSingleResult()
				;
	}

	@Override
	public List<Libro> seleccionarPorFechaNamed(LocalDate fechaPublicacion) {
		TypedQuery<Libro>query=this.entityManager.createNamedQuery("Libro.queryBuscarPorFecha",Libro.class);
		query.setParameter("fecha", fechaPublicacion);
		return query.getResultList();
	}

	//NativeQuery
	@Override
	public Libro encontrarPorTitulo(String titulo) {
		Query query=this.entityManager.createNativeQuery("select * from libro l where l.libr_titulo=:titulo", Libro.class);
		query.setParameter("titulo", titulo);
		return (Libro) query.getSingleResult();
	}

	@Override
	public List<Libro> encontrarPorEditorial(String editorial) {
		Query query=this.entityManager.createNativeQuery("select * from libro l where l.libr_editorial=:editorial",Libro.class);
		query.setParameter("editorial", editorial);
		return (List<Libro>)query.getResultList();
	}

	@Override
	public List<Libro> encontrarPorFechaPublicacion(LocalDate fechaPublicacion) {
		Query query=this.entityManager.createNativeQuery("select * from libro l where l.libr_fecha_publicacion=:fecha",Libro.class);
		query.setParameter("fecha", fechaPublicacion);
		return (List<Libro>)query.getResultList();
	}



}
