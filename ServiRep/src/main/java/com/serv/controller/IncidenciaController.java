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

import com.serv.models.Incidencia;
import com.serv.models.Usuario;
import com.serv.service.IncidenciaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/incidencia")
public class IncidenciaController {

	@Autowired
	IncidenciaService incidencia;
	
	@PostMapping("/crearIncidencia/{us}")
	public void crearIncidencia(@RequestBody Incidencia inc, @PathVariable int us) {
		incidencia.crearIncidencia(inc, us);
	}
	
	@GetMapping("/getIncidencia")
	public List <Incidencia> getIncidencia() {
		return incidencia.getIncidencias();
	}
	
	@DeleteMapping("/borrarIncidencia/{id}")
	public void borrarIncidencia(@PathVariable Integer id) {
		incidencia.borrarIncidencia(id);
	}
}
