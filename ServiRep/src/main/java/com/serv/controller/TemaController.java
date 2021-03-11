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

import com.serv.models.Tema;
import com.serv.models.Ticket;
import com.serv.repository.TemaRepository;
import com.serv.service.TemaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/tema")
public class TemaController {
	
	@Autowired
	TemaService temarep;
		
	@PostMapping("/crearTema/{idusuario}")
	public void crearTema(@RequestBody Tema tema, @PathVariable int idusuario) {
		temarep.crearTema(tema, idusuario);
	}
	
	@GetMapping("/getTemas")
	public List<Tema> getTemas(){		
		return temarep.getTemas();
	}
	
	@GetMapping("/getTemaId/{idtema}")
	public Tema getTemaId(@PathVariable int idtema){		
		return temarep.getTemaId(idtema);
	}
	
	@DeleteMapping("/borrarTema/{idtema}")
	public void borrarTemaa(@PathVariable int idtema) {
		temarep.borrarTemaa(idtema);
	}

}
