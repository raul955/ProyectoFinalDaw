package com.serv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.serv.models.Tema;
import com.serv.models.Ticket;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Integer> {

	@Query(value= "SELECT * FROM tema ORDER BY fecha_creacion DESC", nativeQuery = true)
	List<Tema> getTemas();
	
	@Query(value= "SELECT * FROM tema WHERE idtema = ?1" , nativeQuery = true)
	Tema getTemaId(int idtema);

}
