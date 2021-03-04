package com.serv.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(targetEntity = Usuario.class)
	private Usuario us;
	
	@Column(name = "fechaCreacion")
	private LocalDate fechaCreacion;
	
	public Tema() {
		super();
	}
	
	public Tema(String asunto, String descripcion, Usuario us, LocalDate fechaCreacion) {
		super();
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.us = us;
		this.fechaCreacion = fechaCreacion;
	}

	public Tema(Integer idtema, String asunto, String descripcion, Usuario us, LocalDate fechaCreacion) {
		super();
		this.idtema = idtema;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.us = us;
		this.fechaCreacion = fechaCreacion;
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

	public Usuario getUs() {
		return us;
	}

	public void setUs(Usuario us) {
		this.us = us;
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
		result = prime * result + ((asunto == null) ? 0 : asunto.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((idtema == null) ? 0 : idtema.hashCode());
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
		Tema other = (Tema) obj;
		if (asunto == null) {
			if (other.asunto != null)
				return false;
		} else if (!asunto.equals(other.asunto))
			return false;
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
		if (idtema == null) {
			if (other.idtema != null)
				return false;
		} else if (!idtema.equals(other.idtema))
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
		return "Tema [idtema=" + idtema + ", asunto=" + asunto + ", descripcion=" + descripcion + ", us=" + us
				+ ", fechaCreacion=" + fechaCreacion + "]";
	}

}
