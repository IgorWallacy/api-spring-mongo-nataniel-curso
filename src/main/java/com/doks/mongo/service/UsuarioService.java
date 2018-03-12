package com.doks.mongo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.doks.mongo.model.Usuario;
import com.doks.mongo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> buscar() {
		
		return repository.findAll();
	}

	public ResponseEntity<Usuario> salvar(Usuario usuario) {
		
		 repository.save(usuario);
		 
		 return ResponseEntity.ok().body(usuario); 
	}

	public ResponseEntity<?> excluir(String id) {
		
		 repository.delete(id);
		 
		 return ResponseEntity.ok().body("Excluido com succeso " + id);
		
		
	}
	
	public Usuario buscarUsuarioUnico(String id) {
		
		return repository.findOne(id);
	}

	public Page<Usuario> buscarPaginado(int page, int count) {
		
		
		PageRequest pages = new PageRequest(page, count);
		
		return repository.findAll(pages);
	}
	
	public List<Usuario> buscarPeloNome(String nome){
		
		return repository.findByNomeLikeIgnoreCase(nome);
		
	}

	
}
