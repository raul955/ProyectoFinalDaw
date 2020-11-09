package com.serv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.serv.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query(value = "SELECT * FROM usuario WHERE correo like ?1 and pass like ?2", nativeQuery = true)
	Usuario logearse(String correo, String pass);

}
