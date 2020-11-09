package com.serv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "calificaciones")
public class Calificaciones {

	@Id
	@Column(name = "idcalificaciones")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcalificaciones;

	@Column(name = "calificacion")
	private Integer calificacion;

	@OneToMany(targetEntity = Empleado.class)
	private Empleado emp;

	public Calificaciones() {
		super();
	}

	public Calificaciones(Integer idcalificaciones, Integer calificacion, Empleado emp) {
		super();
		this.idcalificaciones = idcalificaciones;
		this.calificacion = calificacion;
		this.emp = emp;
	}

	public Integer getIdcalificaciones() {
		return idcalificaciones;
	}

	public void setIdcalificaciones(Integer idcalificaciones) {
		this.idcalificaciones = idcalificaciones;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public Empleado getEmp() {
		return emp;
	}

	public void setEmp(Empleado emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Calificaciones [idcalificaciones=" + idcalificaciones + ", calificacion=" + calificacion + ", emp="
				+ emp + "]";
	}

}
