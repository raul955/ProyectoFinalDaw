package com.serv.models;

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
	
	@OneToMany(targetEntity = Empleado.class)
	private Empleado emp;
	
	@OneToMany(targetEntity = Empleado.class)
	private Usuario us;
	
	public Tema() {
		super();
	}

	public Tema(Integer idtema, String asunto, String descripcion, Empleado emp, Usuario us) {
		super();
		this.idtema = idtema;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.emp = emp;
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

	public Empleado getEmp() {
		return emp;
	}

	public void setEmp(Empleado emp) {
		this.emp = emp;
	}

	public Usuario getUs() {
		return us;
	}

	public void setUs(Usuario us) {
		this.us = us;
	}

	@Override
	public String toString() {
		return "Tema [idtema=" + idtema + ", asunto=" + asunto + ", descripcion=" + descripcion + ", emp=" + emp
				+ ", us=" + us + "]";
	}

}
