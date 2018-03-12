package com.doks.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doks.mongo.model.Usuario;
import com.doks.mongo.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService service;
	
	@GetMapping
	public List<Usuario> listaUsuarios() {
		
		
		return service.buscar();
	}
	
	@GetMapping("{page}/{count}")
	public Page<Usuario> listaUsuariosPaginado(@PathVariable int page, @PathVariable int count) {
		
		
		return service.buscarPaginado(page , count);
	}
	
	@GetMapping("{nome}/nome")
	public List<Usuario> porNome(@PathVariable String nome) {
		
		
		return service.buscarPeloNome(nome);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario){
		
		return service.salvar(usuario);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> excluir(@PathVariable String id){
		
		return service.excluir(id);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
		
		return service.salvar(usuario);
	}
	
	@GetMapping("{id}")
	public Usuario buscarUnico(@PathVariable String id) {
		
		return service.buscarUsuarioUnico(id);
		
	}
	
	
	
}
