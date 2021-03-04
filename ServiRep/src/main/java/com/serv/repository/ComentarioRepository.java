package com.serv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.serv.models.Comentario;
import com.serv.models.Tema;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
	
	//SELECT * FROM ticket JOIN ticket_usuario_empleado WHERE ticket_usuario_empleado.ticket_idticket = ticket.idticket 
	
	@Query(value= "SELECT * FROM comentario WHERE tema_idtema = ?1" , nativeQuery = true)
	List<Comentario> getComentariosTemas(int idtema);

}
