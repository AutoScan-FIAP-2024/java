package br.com.fiap.beans;

import br.com.fiap.model.Endereco;

public class Cliente extends Endereco {

	private String nome;
	private String senha;
	private String email;
	private String cep;
	
	public Cliente() {
		
	}

	public Cliente(String estado, String cidade, String bairro, String nome, String senha, String email, String cep) {
	    super(estado, cidade, bairro);
	    this.nome = nome;
	    this.senha = senha;
	    this.email = email;
	    this.cep = cep;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
}
