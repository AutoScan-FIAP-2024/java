package br.com.fiap.beans;

import java.util.regex.Pattern;

public class Funcionarios {
	
	private int código_funcionario;
	private String nome_funcionario;
	private Pattern cpf;
	private Pattern rg;
	private Pattern telefone;
	
	public Funcionarios(){
		
	}

	public Funcionarios(int código_funcionario, String nome_funcionario, Pattern cpf, Pattern rg, Pattern telefone) {
		this.código_funcionario = código_funcionario;
		this.nome_funcionario = nome_funcionario;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
	}

	public int getCódigo_funcionario() {
		return código_funcionario;
	}

	public void setCódigo_funcionario(int código_funcionario) {
		this.código_funcionario = código_funcionario;
	}

	public String getNome_funcionario() {
		return nome_funcionario;
	}

	public void setNome_funcionario(String nome_funcionario) {
		this.nome_funcionario = nome_funcionario;
	}

	public Pattern getCpf() {
		return cpf;
	}

	public void setCpf(Pattern cpf) {
		this.cpf = cpf;
	}

	public Pattern getRg() {
		return rg;
	}

	public void setRg(Pattern rg) {
		this.rg = rg;
	}

	public Pattern getTelefone() {
		return telefone;
	}

	public void setTelefone(Pattern telefone) {
		this.telefone = telefone;
	}

	
	
}


