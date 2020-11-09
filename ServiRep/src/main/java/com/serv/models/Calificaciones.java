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
@Table(name = "calificaciones")
public class Calificaciones {

	@Id
	@Column(name = "idcalificaciones")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcalificaciones;

	@OneToMany( targetEntity=Usuario.class )
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
	
}
