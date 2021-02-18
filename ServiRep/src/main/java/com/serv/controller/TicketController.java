package com.serv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serv.models.Estado;
import com.serv.models.Incidencia;
import com.serv.models.Ticket;
import com.serv.models.Usuario;
import com.serv.service.TicketService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/ticket")
public class TicketController {

	@Autowired
	TicketService tick;
	
	@PostMapping("/crearTicketUsuario/{us}")
	public void crearTicketUsuario(@RequestBody Ticket ticket, @PathVariable int us) {
		tick.crearTicketUsuario(ticket, us);
	}
	
	@PostMapping("/crearTicket/{idincidencia}/{idoperario}")
	public void creatTicket(@RequestBody Ticket ticket, @PathVariable int idincidencia, @PathVariable int idoperario) {
		tick.crearTicket(ticket, idincidencia, idoperario);
	}
	
	/*Gestion de tickets, asigna estado y operario al ticket*/
	@PostMapping("/gestionTicket/{idticket}/{idusuario}")
	public void gestionTicket(@RequestBody Ticket ticket, @PathVariable int idticket, @PathVariable int idusuario) {
		tick.gestionTicket(ticket, idticket, idusuario);
	}
	
	/*Carga los tickets en la vista del usuario cliente*/
	@GetMapping("/cargartickets/{idusuario}")
	public List<Ticket> getTicket(@PathVariable int idusuario){		
		return tick.getTicket(idusuario);
	}
	
	/*Carga los tickets en la vista del operario*/
	@GetMapping("/cargarTicketsOperario/{idusuario}")
	public List<Ticket> getTicketOperario(@PathVariable int idusuario){		
		return tick.getTicketOperario(idusuario);
	}
	
	@GetMapping("/verTodosLosTickets")
	public List<Ticket> getTodosLosTickets(){		
		return tick.getTodosLosTicket();
	}
	
	/*Añade comentario y calificacion a los tickets desde la vista del usuario*/
	@PostMapping("/agregarcomentarioycalificacion/{idticket}/{comentario}/{calificacion}")
	public void agregarcomentarioycalificacion(@RequestBody Ticket ticket, @PathVariable int idticket, @PathVariable String comentario, @PathVariable int calificacion) {
		tick.añadirComentarioCalificacionTicket(idticket, comentario, calificacion);
	}
	
	/*Añade comentario del empleado y estado a los tickets desde la vista del empleado*/
	@PostMapping("/agregarcomentarioyestado/{idticket}/{comentario}")
	public void agregarcomentarioyestado(@RequestBody Ticket ticket, @PathVariable int idticket, @PathVariable String comentario) {
		tick.agregarcomentarioyestado(ticket, idticket, comentario);
	}
	
	@DeleteMapping("/borrarTickets/{idticket}")
	public void borrarTickets(@PathVariable int idticket) {
		tick.borrarTickets(idticket);
	}
	
}
