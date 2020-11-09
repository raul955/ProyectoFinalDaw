package com.serv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column(name = "idusuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuario;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "nick", unique = true)
	private String nick;

	@Column(name = "pass")
	@NotNull
	private String pass;

	@Column(name = "correo", unique = true)
	private String correo;

	@Column(name = "roll")
	@NotNull
	private Roles roll;

	@Column(name = "calificacionMedia")
	private Integer calificacion;

	public Usuario() {
		super();
	}

	public Usuario(Integer idusuario, String nombre, String apellidos, String nick, String pass, String correo,
			Roles roll, Integer calificacion) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nick = nick;
		this.pass = pass;
		this.correo = correo;
		this.roll = roll;
		this.calificacion = calificacion;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setidusuario(Integer idusuario) {
		this.idusuario = idusuario;
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

	public Roles getRoll() {
		return roll;
	}

	public void setRoll(Roles roll) {
		this.roll = roll;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nick="
				+ nick + ", pass=" + pass + ", correo=" + correo + ", roll=" + roll + ", calificacion=" + calificacion
				+ "]";
	}

}
