package com.serv.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

	@ManyToMany(targetEntity = Usuario.class)
	private Set<Usuario> us;
	
	@ManyToMany(targetEntity = Tema.class)
	private Set<Tema> tema;
	
	@Column(name = "fechaCreacion")
	private LocalDate fechaCreacion;

	public Comentario() {
		super();
	}

	public Comentario(Integer idcomentario, String descripcion, Set<Usuario> us, Set<Tema> tema,
			LocalDate fechaCreacion) {
		super();
		this.idcomentario = idcomentario;
		this.descripcion = descripcion;
		this.us = us;
		this.tema = tema;
		this.fechaCreacion = fechaCreacion;
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

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((idcomentario == null) ? 0 : idcomentario.hashCode());
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
		result = prime * result + ((us == null) ? 0 : us.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (idcomentario == null) {
			if (other.idcomentario != null)
				return false;
		} else if (!idcomentario.equals(other.idcomentario))
			return false;
		if (tema == null) {
			if (other.tema != null)
				return false;
		} else if (!tema.equals(other.tema))
			return false;
		if (us == null) {
			if (other.us != null)
				return false;
		} else if (!us.equals(other.us))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentario [idcomentario=" + idcomentario + ", descripcion=" + descripcion + ", us=" + us + ", tema="
				+ tema + ", fechaCreacion=" + fechaCreacion + "]";
	}
}
