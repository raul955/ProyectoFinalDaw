package com.serv.service;

import java.util.List;

import com.serv.models.Incidencia;
import com.serv.models.Usuario;

public interface IncidenciaService {

	void crearIncidencia(Incidencia incidencia, int idusuario);
	
	List <Incidencia> getIncidencias();
	
	void borrarIncidencia (Integer id);
	
}
