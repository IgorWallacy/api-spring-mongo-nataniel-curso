package com.doks.mongo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.doks.mongo.model.Perfil;
import com.doks.mongo.model.Usuario;
import com.doks.mongo.repository.Perfilrepository;
import com.doks.mongo.repository.UsuarioRepository;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private Perfilrepository perfilrepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		List<Perfil> perfis = perfilrepository.findAll();
		
		if(perfis.isEmpty()) {
			Perfil perfil = new Perfil();
			perfil.setNome("ROLE_ADMIN");
			perfilrepository.save(perfil);
			
			Perfil perfilSalvo = perfilrepository.findByNome("ROLE_ADMIN");
			
			List<Perfil> perfisUsuario = new ArrayList<>();
			perfisUsuario.add(perfilSalvo);
			
			usuarioRepository.save(new Usuario("Doks" , perfisUsuario, "admin" , "123"));
			
		}
		
	}

	
}
