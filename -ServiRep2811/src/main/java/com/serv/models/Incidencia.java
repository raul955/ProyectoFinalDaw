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
@Table(name = "incidencia")
public class Incidencia {

	@Id
	@Column(name = "idincidencia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idincidencia;

	@Column(name = "asunto")
	private String asunto;

	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToMany(targetEntity = Usuario.class)
	private Set<Usuario> us;
	
	@Column(name = "activo")
	private Boolean activo;

	public Incidencia() {
		super();
	}

	public Incidencia(Integer idincidencia, String asunto, String descripcion, Set<Usuario> us, Boolean activo) {
		super();
		this.idincidencia = idincidencia;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.us = us;
		this.activo = activo;
	}

	public Integer getIdincidencia() {
		return idincidencia;
	}

	public void setIdincidencia(Integer idincidencia) {
		this.idincidencia = idincidencia;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
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

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Incidencia [idincidencia=" + idincidencia + ", asunto=" + asunto + ", descripcion=" + descripcion
				+ ", us=" + us + ", activo=" + activo + "]";
	}

}
