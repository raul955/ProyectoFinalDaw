package com.serv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serv.models.Incidencia;
import com.serv.models.Usuario;
import com.serv.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void addUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		System.out.println(usuario);
	}

	@Override
	public Usuario logearse(String correo, String pass) {
		return usuarioRepository.logearse(correo, pass);
	}

	@Override
	public List<Usuario> getUsuarios() {
		
		return usuarioRepository.getUsuarios();
	}

}
