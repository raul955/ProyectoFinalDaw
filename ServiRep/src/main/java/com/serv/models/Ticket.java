package com.serv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private String estado;

	@OneToMany(targetEntity = Usuario.class)
	private Usuario us;

	@OneToMany(targetEntity = Empleado.class)
	private Empleado emp;

	@OneToOne(targetEntity = Incidencia.class)
	private Incidencia inc;

	public Ticket() {
		super();
	}

	public Ticket(Integer idticket, String detalle, String comentarioemp, String comentarious, String estado,
			Usuario us, Empleado emp, Incidencia inc) {
		super();
		this.idticket = idticket;
		this.detalle = detalle;
		this.comentarioemp = comentarioemp;
		this.comentarious = comentarious;
		this.estado = estado;
		this.us = us;
		this.emp = emp;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUs() {
		return us;
	}

	public void setUs(Usuario us) {
		this.us = us;
	}

	public Empleado getEmp() {
		return emp;
	}

	public void setEmp(Empleado emp) {
		this.emp = emp;
	}

	public Incidencia getInc() {
		return inc;
	}

	public void setInc(Incidencia inc) {
		this.inc = inc;
	}

	@Override
	public String toString() {
		return "Ticket [idticket=" + idticket + ", detalle=" + detalle + ", comentarioemp=" + comentarioemp
				+ ", comentarious=" + comentarious + ", estado=" + estado + ", us=" + us + ", emp=" + emp + ", inc="
				+ inc + "]";
	}

}
