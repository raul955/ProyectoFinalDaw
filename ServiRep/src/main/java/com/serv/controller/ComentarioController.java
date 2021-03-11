package com.serv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serv.models.Comentario;
import com.serv.models.Tema;
import com.serv.service.ComentarioService;
import com.serv.service.TemaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/comentario")
public class ComentarioController {
	
	@Autowired
	ComentarioService comenrep;
	
	/*Crea un nuevo comentario*/
	@PostMapping("/crearComentario/{idusuario}/{idtema}")
	public void crearTema(@RequestBody Comentario c, @PathVariable int idusuario, @PathVariable int idtema) {
		comenrep.crearComentario(c, idusuario, idtema);
	}
	
	@GetMapping("/getComentariosTemas/{idtema}")
	public List<Comentario> getComentariosTemas(@PathVariable int idtema){		
		return comenrep.getComentariosTemas(idtema);
	}
	
	@DeleteMapping("/borrarComentario/{idcomentario}")
	public void borrarComentarioo(@PathVariable int idcomentario) {
		comenrep.borrarComentarioo(idcomentario);
	}

}
