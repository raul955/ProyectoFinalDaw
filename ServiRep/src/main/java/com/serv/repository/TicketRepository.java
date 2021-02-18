package com.serv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.serv.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	@Query(value= "SELECT * FROM ticket JOIN ticket_usuario_creador WHERE ticket_usuario_creador.ticket_idticket = ticket.idticket AND ticket_usuario_creador.usuario_creador_idusuario = ?1", nativeQuery = true)
	List<Ticket> getTicket(int idusuario);
	
	@Query(value= "SELECT * FROM ticket JOIN ticket_usuario_empleado WHERE ticket_usuario_empleado.ticket_idticket = ticket.idticket AND ticket_usuario_empleado.usuario_empleado_idusuario = ?1", nativeQuery = true)
	List<Ticket> getTicketOperario(int idusuario);
	
	@Query(value= "SELECT * FROM ticket" , nativeQuery = true)
	List<Ticket> getTodosLosTicket();

}
