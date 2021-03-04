package com.serv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.serv.models.Incidencia;
import com.serv.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query(value = "SELECT * FROM usuario WHERE correo like ?1 and pass like ?2", nativeQuery = true)
	Usuario logearse(String correo, String pass);
	
	@Query(value= "SELECT * FROM usuario", nativeQuery = true)
	List <Usuario> getUsuarios();
	
	@Query(value= "SELECT * FROM usuario WHERE roll = 1 ORDER BY calificacion_media DESC;", nativeQuery = true)
	List <Usuario> getRanking();
}
