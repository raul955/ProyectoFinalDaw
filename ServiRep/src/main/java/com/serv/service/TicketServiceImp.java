package com.serv.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serv.models.Estado;
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
	
	
	/*Gestion tickets asigna operario y estado*/
	@Override
	public void gestionTicket(Ticket ticket, int idticket, int idusuario) {
		
		Set <Usuario> us = new HashSet<>();	
		
		Usuario u = usuariorep.getOne(idusuario);
		Ticket tick = ticketrep.getOne(idticket);
		
		us.add(u);
		
		tick.setEs(ticket.getEs());
		
		Estado e = ticket.getEs();
		if(e == Estado.RESUELTO) {
			LocalDate date = LocalDate.now();
			tick.setFechaFinalizacion(date);
		}
		
		tick.setUsuarioEmpleado(us);

		ticketrep.save(tick);
		
	}

	/*Carga los tickets desde la vista del cliente*/
	@Override
	public List<Ticket> getTicket(int idusuario) {		
		return ticketrep.getTicket(idusuario);
	}

	/*Añade comentario del empleado y estado a los tickets desde la vista del empleado*/
	@Override
	public void agregarcomentarioyestado(Ticket ticket, int idticket, String comentario) {
		
		Ticket t = ticketrep.getOne(idticket);		
		t.setComentarioemp(comentario);
		t.setEs(ticket.getEs());
		Estado e = t.getEs();
		
		if(e == Estado.RESUELTO) {
			LocalDate date = LocalDate.now();
			t.setFechaFinalizacion(date);
		}
		
		ticketrep.save(t);		
	}
	
	
	/*Añade comentario y calificacion a los tickets desde la vista del usuario*/
	@Override
	public void añadirComentarioCalificacionTicket(int idticket, String comentario, int calificacion) {
		
		Ticket t = ticketrep.getOne(idticket);		
		t.setComentarious(comentario);
		t.setPuntuacion(calificacion);
		ticketrep.save(t);		
	}

	/*Devuelve todos los tickets de la bbdd*/
	@Override
	public List<Ticket> getTodosLosTicket() {		
		return ticketrep.getTodosLosTicket();
	}

	@Override
	public void crearTicket(Ticket ticket, int idincidencia, int idoperario) {
	}

	/*El usuario crea la incidencia*/
	@Override
	public void crearTicketUsuario(Ticket ticket, int idusuario) {
		
		LocalDate date = LocalDate.now();

		Set <Usuario> us = new HashSet<>();		
		
		Usuario usss = usuariorep.getOne(idusuario);
		
		us.add(usss);
		
		String informacion = ticket.getAsunto() +": " + ticket.getDescripcion(); 
		Ticket tick = new Ticket(ticket.getAsunto(),ticket.getDescripcion(),ticket.getEs(),us, date, informacion);
		
		ticketrep.save(tick);		
	}

	/*Carga los tickets desde la vista del operario*/
	@Override
	public List<Ticket> getTicketOperario(int idusuario) {
		return ticketrep.getTicketOperario(idusuario);
	}

	/*Borra el ticket vista de administrador*/
	@Override
	public void borrarTickets(int idticket) {
		Ticket t = ticketrep.getOne(idticket);		
		ticketrep.delete(t);		
	}

}
