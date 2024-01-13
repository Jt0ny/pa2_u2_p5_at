package com.uce.edu.repository.modelo;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="libro")
@NamedQuery(name ="Libro.queryBuscarPorTitulo",query = "Select l from Libro l where l.titulo=:titulo" )
@NamedQuery(name="Libro.queryBuscarPorFecha",query = "select l from Libro l where l.fechaPublicacion >=:fecha")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_libro" )
	@SequenceGenerator(name = "seq_libro",sequenceName = "seq_libro",allocationSize = 1)
	@Column(name="libr_id")
	private Integer id;
	
	@Column(name="libr_titulo")
	private String titulo;
	
	@Column(name="libr_fecha_publicacion")
	private LocalDate fechaPublicacion;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="autor_libro",
	joinColumns = @JoinColumn(name="auli_id_libro"),//tabla secundaria
	inverseJoinColumns = @JoinColumn(name="auli_id_autor"))//tabla principal 
	private Set<Autor> autores;

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", fechaPublicacion=" + fechaPublicacion + "]";
	}
	//set y get 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public Set<Autor> getAutores() {
		return autores;
	}
	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}
	
	
}
