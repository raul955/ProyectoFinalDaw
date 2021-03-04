package com.serv.service;

import java.util.List;

import com.serv.models.Incidencia;
import com.serv.models.Usuario;

public interface UsuarioService {

	void addUsuario(Usuario usuario);
	
	Usuario logearse(String correo, String pass);
	
	List <Usuario> getUsuarios();
	
	void borrarUsuario(Integer idusuario);
	
	void modificaUsuario(Usuario usuario);
	
	List <Usuario> getRanking();
}
