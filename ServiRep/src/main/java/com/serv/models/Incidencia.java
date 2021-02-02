package com.serv.models;

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
	
	@ManyToMany(targetEntity = Usuario.class)
	private Set<Usuario> us;
	
	@Column(name = "activo")
	private Boolean activo;
	
	@Column(name = "creado")
	private Boolean creado;
	
	public Incidencia() {
		super();
	}

	public Incidencia(String asunto, String descripcion, Set<Usuario> us, Boolean activo) {
		super();
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.us = us;
		this.activo = activo;
	}

	public Incidencia(Integer idincidencia, String asunto, String descripcion, Set<Usuario> us, Boolean activo,
			Boolean creado) {
		super();
		this.idincidencia = idincidencia;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.us = us;
		this.activo = activo;
		this.creado = creado;
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

	public Boolean getCreado() {
		return creado;
	}

	public void setCreado(Boolean creado) {
		this.creado = creado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activo == null) ? 0 : activo.hashCode());
		result = prime * result + ((asunto == null) ? 0 : asunto.hashCode());
		result = prime * result + ((creado == null) ? 0 : creado.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idincidencia == null) ? 0 : idincidencia.hashCode());
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
		Incidencia other = (Incidencia) obj;
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
			return false;
		if (asunto == null) {
			if (other.asunto != null)
				return false;
		} else if (!asunto.equals(other.asunto))
			return false;
		if (creado == null) {
			if (other.creado != null)
				return false;
		} else if (!creado.equals(other.creado))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idincidencia == null) {
			if (other.idincidencia != null)
				return false;
		} else if (!idincidencia.equals(other.idincidencia))
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
		return "Incidencia [idincidencia=" + idincidencia + ", asunto=" + asunto + ", descripcion=" + descripcion
				+ ", us=" + us + ", activo=" + activo + ", creado=" + creado + "]";
	}

}
