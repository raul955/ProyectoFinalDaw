package com.serv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serv.models.Usuario;
import com.serv.service.UsuarioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService us;
	
	@PostMapping("/registrarse")
	public void addUsuario(@RequestBody Usuario usuario) {
		us.addUsuario(usuario);
	}
	
	@GetMapping("/login/{correo}/{pass}")
	public Usuario logearse(@PathVariable String correo,@PathVariable String pass) {
		return us.logearse(correo, pass);
	}

}
