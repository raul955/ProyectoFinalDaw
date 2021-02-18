package com.serv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.serv.models.Tema;
import com.serv.models.Ticket;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Integer> {

	@Query(value= "SELECT * FROM tema", nativeQuery = true)
	List<Tema> getTemas();
	
	

}
