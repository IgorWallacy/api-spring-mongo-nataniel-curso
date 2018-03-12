package com.doks.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doks.mongo.model.Perfil;
import com.doks.mongo.service.PerfilService;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private PerfilService service;
	
	@GetMapping
	private List<Perfil> listar() {
		
		
		return service.todos();
		
	}
	
	@PostMapping
	private Perfil salvar(@RequestBody Perfil perfil){
		
		return service.salvar(perfil);
		
	}

}
