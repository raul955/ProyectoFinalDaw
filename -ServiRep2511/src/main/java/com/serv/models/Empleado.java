package com.serv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@Column(name = "idempleado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idempleado;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "nick", unique = true)
	private String nick;

	@Column(name = "pass")
	private String pass;

	@Column(name = "correo")
	private String correo;

	@Column(name = "rol")
	private String rol;

	@Column(name = "calificacionMedia")
	private Double calificacionMedia;

	public Empleado() {
		super();
	}

	public Empleado(Integer idempleado, String nombre, String apellidos, String nick, String pass, String correo,
			String rol, Double calificacionMedia) {
		super();
		this.idempleado = idempleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nick = nick;
		this.pass = pass;
		this.correo = correo;
		this.rol = rol;
		this.calificacionMedia = calificacionMedia;
	}

	public Integer getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(Integer idempleado) {
		this.idempleado = idempleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Double getCalificacionMedia() {
		return calificacionMedia;
	}

	public void setCalificacionMedia(Double calificacionMedia) {
		this.calificacionMedia = calificacionMedia;
	}

	@Override
	public String toString() {
		return "Empleado [idempleado=" + idempleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nick="
				+ nick + ", pass=" + pass + ", correo=" + correo + ", rol=" + rol + ", calificacionMedia="
				+ calificacionMedia + "]";
	}

}
