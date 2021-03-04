package com.serv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serv.models.Incidencia;
import com.serv.models.Ticket;
import com.serv.models.Usuario;
import com.serv.repository.IncidenciaRepository;
import com.serv.repository.TicketRepository;
import com.serv.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	IncidenciaRepository incidenciarep;
	
	@Autowired
	TicketRepository ticketrep;
	
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

	/*Borra el usuario en la vista de administración de usuarios*/
	@Override
	public void borrarUsuario(Integer idusuario) {
		
		List<Ticket> tick = ticketrep.getTicketOperario(idusuario);
		for(int i =0; i<tick.size(); i++) {
			ticketrep.delete(tick.get(i));
		}
		
		List<Ticket> tickus = ticketrep.getTicket(idusuario);
		for(int i =0; i<tickus.size(); i++) {
			ticketrep.delete(tickus.get(i));
		}
		
		Usuario user = usuarioRepository.getOne(idusuario);
		usuarioRepository.delete(user);		
	}
	
	/*Modifica usuario parte de administrador*/
	public void modificaUsuario(Usuario usuario){
		
		Usuario u = usuarioRepository.getOne(usuario.getIdusuario());
		u.setRoll(usuario.getRoll());
		
		usuarioRepository.save(u);
		
	}

	/*Trae los operarios ordenados para el ranking*/
	@Override
	public List<Usuario> getRanking() {
		return usuarioRepository.getRanking();
	}

}
