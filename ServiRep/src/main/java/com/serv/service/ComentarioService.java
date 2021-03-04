package com.serv.service;

import java.util.List;

import com.serv.models.Comentario;
import com.serv.models.Tema;

public interface ComentarioService {
	
	/*Crea un tema para el foro*/
	void crearComentario(Comentario comentario, int idusuario, int idtema);
	
	/*Devuelve los comentarios correspondientes a cada tema*/
	List<Comentario> getComentariosTemas(int idetema);

}
