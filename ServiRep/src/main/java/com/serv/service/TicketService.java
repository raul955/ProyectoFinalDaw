package com.serv.service;

import java.util.List;

import com.serv.models.Incidencia;
import com.serv.models.Ticket;

public interface TicketService {
	
	void crearTicket(Ticket ticket, int idincidencia, int idoperario);
	
	List<Ticket> getTicket(int idusuario);

	
	
}
