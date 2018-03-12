package com.doks.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.doks.mongo.model.Perfil;

public interface Perfilrepository extends MongoRepository<Perfil, String> {

	Perfil findByNome(String role_admin);

}
