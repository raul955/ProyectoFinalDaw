package com.serv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario {

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
	@NotNull
	private String pass;

	@Column(name = "correo")
	private String correo;

	@Column(name = "rol")
	@NotNull
	private Roles rol;

	@Column(name = "calificacionMedia")
	private Integer calificacion;

	public Usuario() {
		super();
	}

	public Usuario(Integer idempleado, String nombre, String apellidos, String nick, String pass, String correo,
			Roles rol, Integer calificacion) {
		super();
		this.idempleado = idempleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nick = nick;
		this.pass = pass;
		this.correo = correo;
		this.rol = rol;
		this.calificacion = calificacion;
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

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
		return "Usuario [idempleado=" + idempleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nick="
				+ nick + ", pass=" + pass + ", correo=" + correo + ", rol=" + rol + ", calificacion=" + calificacion
				+ "]";
	}

}
