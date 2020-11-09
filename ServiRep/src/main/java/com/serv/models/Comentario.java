package com.serv.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario {

	@Id
	@Column(name = "idcomentario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcomentario;

	@Column(name = "descripcion")
	private String descripcion;

	@OneToMany(targetEntity = Usuario.class)
	private Set<Usuario> us;
	
	@OneToMany(targetEntity = Tema.class)
	private Set<Tema> tema;

	public Comentario() {
		super();
	}

	public Comentario(Integer idcomentario, String descripcion, Set<Usuario> us, Set<Tema> tema) {
		super();
		this.idcomentario = idcomentario;
		this.descripcion = descripcion;
		this.us = us;
		this.tema = tema;
	}

	public Integer getIdcomentario() {
		return idcomentario;
	}

	public void setIdcomentario(Integer idcomentario) {
		this.idcomentario = idcomentario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Usuario> getUs() {
		return us;
	}

	public void setUs(Set<Usuario> us) {
		this.us = us;
	}

	public Set<Tema> getTema() {
		return tema;
	}

	public void setTema(Set<Tema> tema) {
		this.tema = tema;
	}

	@Override
	public String toString() {
		return "Comentario [idcomentario=" + idcomentario + ", descripcion=" + descripcion + ", us=" + us + ", tema="
				+ tema + "]";
	}

}
