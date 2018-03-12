package com.doks.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doks.mongo.config.MyUserDetails;
import com.doks.mongo.model.Usuario;
import com.doks.mongo.repository.UsuarioRepository;

@Service

public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = repository.findByEmail(username);
		
		if(usuario == null) {
			
			throw new UsernameNotFoundException("Usuário ou senha inválidos");
		}
		
		return new MyUserDetails(usuario);
	}

}
