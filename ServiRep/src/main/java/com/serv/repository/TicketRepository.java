package com.serv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.serv.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	@Query(value= "SELECT * FROM ticket JOIN ticket_inc JOIN incidencia_us WHERE ticket_inc.ticket_idticket = ticket.idticket AND ticket_inc.inc_idincidencia = incidencia_us.incidencia_idincidencia AND incidencia_us.us_idusuario = ?1", nativeQuery = true)
	List<Ticket> getTicket(int idusuario);
	
	@Query(value= "SELECT * FROM ticket" , nativeQuery = true)
	List<Ticket> getTodosLosTicket();

}
