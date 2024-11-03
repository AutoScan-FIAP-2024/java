package br.com.fiap.beans;

import java.util.regex.Pattern;

public class PcdOuIdoso extends Cliente {
	
	private Boolean pcd;
	private Boolean idoso;
	private String historicoMedico;
	private String exames;
	private String laudoDeComprovacao;
	
	public PcdOuIdoso() {
		
	}

	public PcdOuIdoso(String nome, Pattern senha, Pattern email, String estado, String historicoMedico,
			String exames, String laudoDeComprovacao, Boolean pcd, Boolean idoso) {
		super();
		this.historicoMedico = historicoMedico;
		this.exames = exames;
		this.laudoDeComprovacao = laudoDeComprovacao;
		this.idoso = idoso;
		this.pcd = pcd;
	}

	public String getHistoricoMedico() {
		return historicoMedico;
	}

	public void setHistoricoMedico(String historicoMedico) {
		this.historicoMedico = historicoMedico;
	}

	public String getExames() {
		return exames;
	}

	public void setExames(String exames) {
		this.exames = exames;
	}

	public String getLaudoDeComprovacao() {
		return laudoDeComprovacao;
	}

	public void setLaudoDeComprovacao(String laudoDeComprovacao) {
		this.laudoDeComprovacao = laudoDeComprovacao;
	}

	public Boolean getPcd() {
		return pcd;
	}

	public void setPcd(Boolean pcd) {
		this.pcd = pcd;
	}

	public Boolean getIdoso() {
		return idoso;
	}

	public void setIdoso(Boolean idoso) {
		this.idoso = idoso;
	}
	
	
	
}
