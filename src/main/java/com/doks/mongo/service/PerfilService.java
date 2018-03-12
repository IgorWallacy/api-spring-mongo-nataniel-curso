package com.doks.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doks.mongo.model.Perfil;
import com.doks.mongo.repository.Perfilrepository;

@Service
public class PerfilService {

	@Autowired
	private Perfilrepository repository;
	
	public List<Perfil> todos() {
		
		return repository.findAll();
	}

	public Perfil salvar(Perfil perfil) {
	
		return repository.save(perfil);
	}

}
