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
@Table(name = "tema")
public class Tema {

	@Id
	@Column(name = "idtema")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtema;
	
	@Column(name = "asunto")
	private String asunto;
	
	@Column(name = "descripcion")
	private String descripcion;
		
	@Column(name = "estado")
	private Boolean estado;
	
	@OneToMany(targetEntity = Usuario.class)
	private Set<Usuario> us;

	public Tema() {
		super();
	}

	public Tema(Integer idtema, String asunto, String descripcion, Boolean estado, Set<Usuario> us) {
		super();
		this.idtema = idtema;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.estado = estado;
		this.us = us;
	}

	public Integer getIdtema() {
		return idtema;
	}

	public void setIdtema(Integer idtema) {
		this.idtema = idtema;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Set<Usuario> getUs() {
		return us;
	}

	public void setUs(Set<Usuario> us) {
		this.us = us;
	}

	@Override
	public String toString() {
		return "Tema [idtema=" + idtema + ", asunto=" + asunto + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", us=" + us + "]";
	}

}
