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
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@Column(name = "idticket")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idticket;

	@Column(name = "asunto")
	private String asunto;

	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "informacion")
	private String informacion;

	@Column(name = "comentarioemp")
	private String comentarioemp;

	@Column(name = "comentarious")
	private String comentarious;

	@Column(name = "estado")
	private Estado es;

	@ManyToOne(targetEntity = Usuario.class)
	private Usuario usuarioCreador;
	
	@ManyToOne(targetEntity = Usuario.class)
	private Usuario usuarioEmpleado;

	@Column(name = "fechaCreacion")
	private LocalDate fechaCreacion;
	
	@Column(name = "fechaFinalizacion")
	private LocalDate fechaFinalizacion;
	
	@Column(name = "puntuacion")
	private int puntuacion;
	
	public Ticket() {
		super();
	}

	
	
	public Ticket(String asunto, String descripcion, Estado es, Usuario usuarioCreador, LocalDate fechaCreacion, String informacion) {
		super();
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.es = es;
		this.usuarioCreador = usuarioCreador;
		this.fechaCreacion = fechaCreacion;
		this.informacion = informacion;
	}

	public Ticket(Integer idticket, String asunto, String descripcion, String informacion, String comentarioemp,
			String comentarious, Estado es, Usuario usuarioCreador, Usuario usuarioEmpleado,
			LocalDate fechaCreacion, LocalDate fechaFinalizacion, int puntuacion) {
		super();
		this.idticket = idticket;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.informacion = informacion;
		this.comentarioemp = comentarioemp;
		this.comentarious = comentarious;
		this.es = es;
		this.usuarioCreador = usuarioCreador;
		this.usuarioEmpleado = usuarioEmpleado;
		this.fechaCreacion = fechaCreacion;
		this.fechaFinalizacion = fechaFinalizacion;
		this.puntuacion = puntuacion;
	}

	public Integer getIdticket() {
		return idticket;
	}

	public void setIdticket(Integer idticket) {
		this.idticket = idticket;
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

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public String getComentarioemp() {
		return comentarioemp;
	}

	public void setComentarioemp(String comentarioemp) {
		this.comentarioemp = comentarioemp;
	}

	public String getComentarious() {
		return comentarious;
	}

	public void setComentarious(String comentarious) {
		this.comentarious = comentarious;
	}

	public Estado getEs() {
		return es;
	}

	public void setEs(Estado es) {
		this.es = es;
	}

	public Usuario getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(Usuario usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}

	public Usuario getUsuarioEmpleado() {
		return usuarioEmpleado;
	}

	public void setUsuarioEmpleado(Usuario usuarioEmpleado) {
		this.usuarioEmpleado = usuarioEmpleado;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asunto == null) ? 0 : asunto.hashCode());
		result = prime * result + ((comentarioemp == null) ? 0 : comentarioemp.hashCode());
		result = prime * result + ((comentarious == null) ? 0 : comentarious.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((es == null) ? 0 : es.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((fechaFinalizacion == null) ? 0 : fechaFinalizacion.hashCode());
		result = prime * result + ((idticket == null) ? 0 : idticket.hashCode());
		result = prime * result + ((informacion == null) ? 0 : informacion.hashCode());
		result = prime * result + puntuacion;
		result = prime * result + ((usuarioCreador == null) ? 0 : usuarioCreador.hashCode());
		result = prime * result + ((usuarioEmpleado == null) ? 0 : usuarioEmpleado.hashCode());
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
		Ticket other = (Ticket) obj;
		if (asunto == null) {
			if (other.asunto != null)
				return false;
		} else if (!asunto.equals(other.asunto))
			return false;
		if (comentarioemp == null) {
			if (other.comentarioemp != null)
				return false;
		} else if (!comentarioemp.equals(other.comentarioemp))
			return false;
		if (comentarious == null) {
			if (other.comentarious != null)
				return false;
		} else if (!comentarious.equals(other.comentarious))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (es != other.es)
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (fechaFinalizacion == null) {
			if (other.fechaFinalizacion != null)
				return false;
		} else if (!fechaFinalizacion.equals(other.fechaFinalizacion))
			return false;
		if (idticket == null) {
			if (other.idticket != null)
				return false;
		} else if (!idticket.equals(other.idticket))
			return false;
		if (informacion == null) {
			if (other.informacion != null)
				return false;
		} else if (!informacion.equals(other.informacion))
			return false;
		if (puntuacion != other.puntuacion)
			return false;
		if (usuarioCreador == null) {
			if (other.usuarioCreador != null)
				return false;
		} else if (!usuarioCreador.equals(other.usuarioCreador))
			return false;
		if (usuarioEmpleado == null) {
			if (other.usuarioEmpleado != null)
				return false;
		} else if (!usuarioEmpleado.equals(other.usuarioEmpleado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [idticket=" + idticket + ", asunto=" + asunto + ", descripcion=" + descripcion + ", informacion="
				+ informacion + ", comentarioemp=" + comentarioemp + ", comentarious=" + comentarious + ", es=" + es
				+ ", usuarioCreador=" + usuarioCreador + ", usuarioEmpleado=" + usuarioEmpleado + ", fechaCreacion="
				+ fechaCreacion + ", fechaFinalizacion=" + fechaFinalizacion + ", puntuacion=" + puntuacion + "]";
	}

	
	
}
