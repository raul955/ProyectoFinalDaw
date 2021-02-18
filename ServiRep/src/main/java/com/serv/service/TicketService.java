package com.serv.service;

import java.util.List;

import com.serv.models.Estado;
import com.serv.models.Incidencia;
import com.serv.models.Ticket;
import com.serv.models.Usuario;

public interface TicketService {
	
	void crearTicket(Ticket ticket, int idincidencia, int idoperario);
	
	/*Carga los tickets desde la vista de usuario cliente*/
	List<Ticket> getTicket(int idusuario);
	
	/*Carga los tickets desde la vista del operario*/
	List<Ticket> getTicketOperario(int idusuario);

	void añadirComentarioCalificacionTicket(int idticket, String comentario, int calificacion);
	
	/*Trae todos los tickets*/
	List<Ticket> getTodosLosTicket();
	
	void crearTicketUsuario(Ticket Ticket, int idusuario);
	
	/*Gestion tickets, asigna estado y operario*/
	void gestionTicket(Ticket ticket, int idticket, int idusuario);
	
	/*Añade comentario del empleado y estado a los tickets desde la vista del empleado*/
	void agregarcomentarioyestado(Ticket ticket, int idticket, String comentarioemp);
	
	/*Borra el ticket desde la parte del gestor*/
	void borrarTickets(int idticket);
	
}
