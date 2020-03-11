package com.serv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario {

	@Id
	@Column(name = "idcomentario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcomentario;

	@Column(name = "descripcion")
	private String descripcion;

	@OneToMany(targetEntity = Usuario.class)
	private Usuario us;
	
	@OneToMany(targetEntity = Empleado.class)
	private Empleado emp;
	
	@OneToMany(targetEntity = Tema.class)
	private Tema tema;

	public Comentario() {
		super();
	}

	public Comentario(Integer idcomentario, String descripcion, Usuario us, Empleado emp, Tema tema) {
		super();
		this.idcomentario = idcomentario;
		this.descripcion = descripcion;
		this.us = us;
		this.emp = emp;
		this.tema = tema;
	}

	public Integer getIdcomentario() {
		return idcomentario;
	}

	public void setIdcomentario(Integer idcomentario) {
		this.idcomentario = idcomentario;
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

	public Empleado getEmp() {
		return emp;
	}

	public void setEmp(Empleado emp) {
		this.emp = emp;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	@Override
	public String toString() {
		return "Comentario [idcomentario=" + idcomentario + ", descripcion=" + descripcion + ", us=" + us + ", emp="
				+ emp + ", tema=" + tema + "]";
	}

}
