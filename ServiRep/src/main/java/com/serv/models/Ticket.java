package com.serv.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@Column(name = "idticket")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idticket;

	@Column(name = "detalle")
	private String detalle;

	@Column(name = "comentarioemp")
	private String comentarioemp;

	@Column(name = "comentarious")
	private String comentarious;

	@Column(name = "estado")
	private Estado es;

	@ManyToMany(targetEntity = Usuario.class)
	private Set<Usuario> us;

	@ManyToMany(targetEntity = Incidencia.class)
	private Set<Incidencia> inc;

	public Ticket() {
		super();
	}

	public Ticket(Integer idticket, String detalle, String comentarioemp, String comentarious, Estado es,
			Set<Usuario> us, Set<Incidencia> inc) {
		super();
		this.idticket = idticket;
		this.detalle = detalle;
		this.comentarioemp = comentarioemp;
		this.comentarious = comentarious;
		this.es = es;
		this.us = us;
		this.inc = inc;
	}
	
	public Ticket(String detalle,Estado es, Set<Usuario> us, Set<Incidencia> inc) {

		this.detalle = detalle;
		this.es = es;
		this.us = us;
		this.inc = inc;
	}

	public Integer getIdticket() {
		return idticket;
	}

	public void setIdticket(Integer idticket) {
		this.idticket = idticket;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
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

	public Set<Usuario> getUs() {
		return us;
	}

	public void setUs(Set<Usuario> us) {
		this.us = us;
	}

	public Set<Incidencia> getInc() {
		return inc;
	}

	public void setInc(Set<Incidencia> inc) {
		this.inc = inc;
	}

	@Override
	public String toString() {
		return "Ticket [idticket=" + idticket + ", detalle=" + detalle + ", comentarioemp=" + comentarioemp
				+ ", comentarious=" + comentarious + ", es=" + es + ", us=" + us + ", inc=" + inc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentarioemp == null) ? 0 : comentarioemp.hashCode());
		result = prime * result + ((comentarious == null) ? 0 : comentarious.hashCode());
		result = prime * result + ((detalle == null) ? 0 : detalle.hashCode());
		result = prime * result + ((es == null) ? 0 : es.hashCode());
		result = prime * result + ((idticket == null) ? 0 : idticket.hashCode());
		result = prime * result + ((inc == null) ? 0 : inc.hashCode());
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
		Ticket other = (Ticket) obj;
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
		if (detalle == null) {
			if (other.detalle != null)
				return false;
		} else if (!detalle.equals(other.detalle))
			return false;
		if (es != other.es)
			return false;
		if (idticket == null) {
			if (other.idticket != null)
				return false;
		} else if (!idticket.equals(other.idticket))
			return false;
		if (inc == null) {
			if (other.inc != null)
				return false;
		} else if (!inc.equals(other.inc))
			return false;
		if (us == null) {
			if (other.us != null)
				return false;
		} else if (!us.equals(other.us))
			return false;
		return true;
	}

}
