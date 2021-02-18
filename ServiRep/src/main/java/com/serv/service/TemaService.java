package com.serv.service;

import java.util.List;

import com.serv.models.Tema;
import com.serv.models.Ticket;

public interface TemaService {
	
	/*Crea un tema para el foro*/
	void crearTema(Tema tema, int idusuario);
	
	List<Tema> getTemas();

}
