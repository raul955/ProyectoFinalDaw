package com.serv.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serv.models.Tema;
import com.serv.models.Ticket;
import com.serv.models.Usuario;
import com.serv.repository.TemaRepository;
import com.serv.repository.UsuarioRepository;

@Service
public class TemaServiceImp implements TemaService{

	@Autowired
	UsuarioRepository usuariorep;
	
	@Autowired
	TemaRepository temarep;
	
	@Override
	public void crearTema(Tema tema, int idusuario) {
		
		LocalDate date = LocalDate.now();

		Set <Usuario> us = new HashSet<>();				
		Usuario usss = usuariorep.getOne(idusuario);		
		us.add(usss);
		
		Tema t = new Tema(tema.getAsunto(), tema.getDescripcion(), us, date);
		temarep.save(t);
	}
	
	/*Devuelve todos los tickets de la bbdd*/
	@Override
	public List<Tema> getTemas() {		
		return temarep.getTemas();
	}

}
