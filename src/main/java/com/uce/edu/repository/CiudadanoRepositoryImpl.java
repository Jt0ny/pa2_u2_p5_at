package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

	//Criterial API query
	@Override
	public Ciudadano seleccionarPorApellidoCAQ(String apellido) {
		
		//SELECT c FROM Ciudadano c WHERE c.apellido = :dato
		
				// 0.- creamos una instancia de la interfaz CriteriaBuilder a partir de un
				// entitymanager
				CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
				// 1.- Determinamos el tipo de retorno que va a tener mi consulta
				CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
				// 2.- Construir nuestro SQL
				// 2.1- Determinar el FROM (Root)
					// no necesariamente el FROM es igual al tipo de retorno
				Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);
				// 2.2- Construir las condiciones (WHERE) del sql
					// en criteria api query las condiciones se las conoce como "PREDICATE"
				//c.apellido = :dato
				Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
				// 3.- Construimos el SQL  final 
				myCriteriaQuery.select(myFrom).where(condicionApellido);
				// 4.- ejecutamos la consulta con un typed query
				TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
				
				return myTypedQuery.getSingleResult();
	
	}

	@Override
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		CriteriaBuilder mCB = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Ciudadano> mCQ = mCB.createQuery(Ciudadano.class);
		Root<Ciudadano> myFrom = mCQ.from(Ciudadano.class);

		Predicate condicionGenerica = null;

		if (cedula.startsWith("17")) {
			condicionGenerica = mCB.equal(myFrom.get("nombre"), nombre);
		} else if (cedula.startsWith("05")) {
			condicionGenerica = mCB.equal(myFrom.get("apellido"), apellido);
		} else {
			condicionGenerica = mCB.equal(myFrom.get("cedula"), cedula);
		}

		mCQ.select(myFrom).where(condicionGenerica);

		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(mCQ);
		return myTypedQuery.getResultList().get(0);
	}
	
	@Override
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		CriteriaBuilder mCB = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Ciudadano> mCQ = mCB.createQuery(Ciudadano.class);
		Root<Ciudadano> myFrom = mCQ.from(Ciudadano.class);

		Predicate condicionTotal = null;
		
		Predicate condicionNombre = mCB.equal(myFrom.get("nombre"), nombre);

		Predicate condicionApellido=mCB.equal(myFrom.get("apellido"), apellido);
		
		if (cedula.startsWith("17")) {
			condicionTotal = mCB.or(condicionNombre,condicionApellido);
		} else if (cedula.startsWith("05")) {
			condicionTotal = mCB.and(condicionNombre,condicionApellido);
		} 

		mCQ.select(myFrom).where(condicionTotal);

		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(mCQ);
		return myTypedQuery.getResultList().get(0);
	}


}
