package com.serv.service;

import java.util.List;

import com.serv.models.Tema;
import com.serv.models.Ticket;

public interface TemaService {
	
	/*Crea un tema para el foro*/
	void crearTema(Tema tema, int idusuario);
	
	/*Obtiene todos los temas*/
	List<Tema> getTemas();
	
	/*Coge el tema*/
	Tema getTemaId(int idtema);

	/*Borra Tema*/
	void borrarTemaa(int idtema);
}
