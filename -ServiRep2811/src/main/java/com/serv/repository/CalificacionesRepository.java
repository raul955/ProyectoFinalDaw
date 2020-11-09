package com.serv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serv.models.Calificaciones;

@Repository
public interface CalificacionesRepository extends JpaRepository<Calificaciones, Integer> {

}