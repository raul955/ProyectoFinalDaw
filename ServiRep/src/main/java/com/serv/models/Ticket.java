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

}
