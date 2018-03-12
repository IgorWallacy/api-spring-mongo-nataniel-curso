package com.doks.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.doks.mongo.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	List<Usuario> findByNomeIgnoreCase(String nome);

	List<Usuario> findByNomeLikeIgnoreCase(String nome);

	Usuario findByEmail(String username);

	

}
