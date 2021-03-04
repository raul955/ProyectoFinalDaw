package com.serv.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serv.models.Comentario;
import com.serv.models.Tema;
import com.serv.models.Usuario;
import com.serv.repository.ComentarioRepository;
import com.serv.repository.TemaRepository;
import com.serv.repository.UsuarioRepository;

@Service
public class ComentarioServiceImp implements ComentarioService{

	@Autowired
	UsuarioRepository usuariorep;
	
	@Autowired
	TemaRepository temarep;
	
	@Autowired
	ComentarioRepository comenrep;
	
	/*Crea un nuevo comentario**/
	@Override
	public void crearComentario(Comentario comentario, int idusuario, int idtema) {
		
		LocalDate date = LocalDate.now();
		Usuario usss = usuariorep.getOne(idusuario);
		Tema tem = temarep.getOne(idtema);
		
		Comentario c = new Comentario(comentario.getDescripcion(), usss, tem, date);
		comenrep.save(c);
		
	}

	/*Devuelve los comentarios correspondientes a cada tema*/
	@Override
	public List<Comentario> getComentariosTemas(int idtema) {
		return comenrep.getComentariosTemas(idtema);
	}

}
