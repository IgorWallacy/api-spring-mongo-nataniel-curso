package com.doks.mongo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario {
	
	@Id
	private String id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private String idade;
	
	@DBRef
	private List<Perfil> perfis;
	
	

	public Usuario() {
		
	}
	
	

	public Usuario(Usuario usuario) {
		
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	//	this.idade = usuario.getIdade();
		this.senha = usuario.getSenha();
		this.perfis = usuario.getPerfis();
	}


	




	public Usuario(String nome, List<Perfil> perfis, String senha, String email) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfis = perfis;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

	
}
