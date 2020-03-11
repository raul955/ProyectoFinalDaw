package com.serv.models;

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
	private Usuario us;

	public Incidencia() {
		super();
	}

	public Incidencia(Integer idincidencia, String asunto, String descripcion, Usuario us) {
		super();
		this.idincidencia = idincidencia;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.us = us;
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

	public Usuario getUs() {
		return us;
	}

	public void setUs(Usuario us) {
		this.us = us;
	}

	@Override
	public String toString() {
		return "Incidencia [idincidencia=" + idincidencia + ", asunto=" + asunto + ", descripcion=" + descripcion
				+ ", us=" + us + "]";
	}

}
