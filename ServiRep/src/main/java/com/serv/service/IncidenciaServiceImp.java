package com.serv.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serv.models.Incidencia;
import com.serv.models.Usuario;
import com.serv.repository.IncidenciaRepository;
import com.serv.repository.UsuarioRepository;

@Service
public class IncidenciaServiceImp implements IncidenciaService{

	@Autowired
	UsuarioRepository usuariorep;
	
	@Autowired
	IncidenciaRepository incidenciarep;
	
	@Override
	public void crearIncidencia(Incidencia incidencia, int idusuario) {
		
		Set <Usuario> us = new HashSet<>();		
		
		Usuario usss = usuariorep.getOne(idusuario);
		
		us.add(usss);
		
		Incidencia inc = new Incidencia(incidencia.getAsunto(),incidencia.getDescripcion(),us,incidencia.getActivo());
		
		incidenciarep.save(inc);
	}

	@Override
	public List<Incidencia> getIncidencias() {
		
		return incidenciarep.getIncidencias();
	}

	@Override
	public void borrarIncidencia(Integer id) {
		
		Incidencia inci = incidenciarep.getOne(id);
		
		incidenciarep.delete(inci);
		
	}

}
