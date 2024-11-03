package br.com.fiap.beans;

public class Contato {
	
	public String telefoneEmpresa;
	public String site;
	
	public Contato() {
		
	}

	public Contato(String telefoneEmpresa, String site) {
		this.telefoneEmpresa = telefoneEmpresa;
		this.site = site;
	}

	public String getTelefoneEmpresa() {
		return telefoneEmpresa;
	}

	public void setTelefoneEmpresa(String telefoneEmpresa) {
		this.telefoneEmpresa = telefoneEmpresa;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	
	
}
