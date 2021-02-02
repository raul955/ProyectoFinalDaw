package com.serv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serv.models.Ticket;
import com.serv.service.TicketService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/ticket")
public class TicketController {

	@Autowired
	TicketService tick;
	
	@PostMapping("/crearTicket/{idincidencia}/{idoperario}")
	public void creatTicket(@RequestBody Ticket ticket, @PathVariable int idincidencia, @PathVariable int idoperario) {
		tick.crearTicket(ticket, idincidencia, idoperario);
	}
	
	@GetMapping("/cargartickets/{idusuario}")
	public List<Ticket> getTicket(@PathVariable int idusuario){
		
		return tick.getTicket(idusuario);
	}
	
	@GetMapping("/verTodosLosTickets")
	public List<Ticket> getTodosLosTickets(){
		
		return tick.getTodosLosTicket();
	}
	
	@PostMapping("/agregarcomentarioycalificacion/{idticket}/{comentario}/{calificacion}/{idusuario}")
	public void agregarcomentarioycalificacion(@RequestBody Ticket ticket, @PathVariable int idticket, @PathVariable String comentario, @PathVariable int calificacion, @PathVariable int idusuario) {
		tick.añadirComentarioCalificacionTicket(idticket, comentario, calificacion, idusuario);
	}
	
}
