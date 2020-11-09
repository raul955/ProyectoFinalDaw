package com.serv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serv.models.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Integer> {

}
