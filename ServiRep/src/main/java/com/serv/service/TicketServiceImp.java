package com.serv.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serv.models.Incidencia;
import com.serv.models.Ticket;
import com.serv.models.Usuario;
import com.serv.repository.IncidenciaRepository;
import com.serv.repository.TicketRepository;
import com.serv.repository.UsuarioRepository;

@Service
public class TicketServiceImp implements TicketService{

	@Autowired
	UsuarioRepository usuariorep;
	
	@Autowired
	IncidenciaRepository incidenciarep;
	
	@Autowired
	TicketRepository ticketrep;
	
	@Override
	public void crearTicket(Ticket ticket, int idincidencia, int idusuario) {
		
		Set <Usuario> us = new HashSet<>();	
		Set <Incidencia> in = new HashSet<>();	
		
		Usuario user = usuariorep.getOne(idusuario);
		Incidencia inc = incidenciarep.getOne(idincidencia);
		
		us.add(user);
		in.add(inc);
		
		Ticket ticketero = new Ticket(ticket.getDetalle(),ticket.getEs(),us,in);
		ticketrep.save(ticketero);
		
	}

	@Override
	public List<Ticket> getTicket(int idusuario) {
		
		return ticketrep.getTicket(idusuario);
	}

}
