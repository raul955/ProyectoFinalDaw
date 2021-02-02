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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asunto == null) ? 0 : asunto.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
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

}
