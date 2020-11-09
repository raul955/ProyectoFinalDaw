package com.serv.service;

import com.serv.models.Usuario;

public interface UsuarioService {

	void addUsuario(Usuario usuario);
	
	Usuario logearse(String correo, String pass);
	
}
