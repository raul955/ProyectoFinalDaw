package com.serv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String pass;

	@Column(name = "correo")
	private String correo;

	@Column(name = "rol")
	private String rol;

	public Usuario() {
		super();
	}

	public Usuario(Integer idusuario, String nombre, String apellidos, String nick, String pass, String correo,
			String rol) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nick = nick;
		this.pass = pass;
		this.correo = correo;
		this.rol = rol;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nick=" + nick
				+ ", pass=" + pass + ", correo=" + correo + ", rol=" + rol + "]";
	}



}
