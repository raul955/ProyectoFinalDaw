package com.serv.models;

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
@Table(name = "calificaciones")
public class Calificaciones {

	@Id
	@Column(name = "idcalificaciones")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcalificaciones;

	@ManyToMany( targetEntity=Usuario.class )
	private Set<Usuario> usuario;
	
	@Column(name = "calificacion")
	private Integer calificacion;

	public Calificaciones() {
		super();
	}

	public Calificaciones(Integer idcalificaciones, Set<Usuario> usuario, Integer calificacion) {
		super();
		this.idcalificaciones = idcalificaciones;
		this.usuario = usuario;
		this.calificacion = calificacion;
	}

	public Integer getIdcalificaciones() {
		return idcalificaciones;
	}

	public void setIdcalificaciones(Integer idcalificaciones) {
		this.idcalificaciones = idcalificaciones;
	}

	public Set<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
		return "Calificaciones [idcalificaciones=" + idcalificaciones + ", usuario=" + usuario + ", calificacion="
				+ calificacion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calificacion == null) ? 0 : calificacion.hashCode());
		result = prime * result + ((idcalificaciones == null) ? 0 : idcalificaciones.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Calificaciones other = (Calificaciones) obj;
		if (calificacion == null) {
			if (other.calificacion != null)
				return false;
		} else if (!calificacion.equals(other.calificacion))
			return false;
		if (idcalificaciones == null) {
			if (other.idcalificaciones != null)
				return false;
		} else if (!idcalificaciones.equals(other.idcalificaciones))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}
