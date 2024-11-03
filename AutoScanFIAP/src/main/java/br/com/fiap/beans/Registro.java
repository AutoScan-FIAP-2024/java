package br.com.fiap.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Registro {
	
	private int código;
	private Date data;
	
	public Registro() {
		
	}

	public Registro(int placa, int código, Date data) {
		this.código = código;
		this.data = data;
	}

	public int getCódigo() {
		return código;
	}

	public void setCódigo(int código) {
		this.código = código;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public int gerarCodigo() {
		int codigo = 0;
		return codigo++;
	}
	
	public java.sql.Date obterDataAtual() {
        return new java.sql.Date(System.currentTimeMillis());
    }

    // Método que retorna a data atual no formato DDMMYY
    public String obterDataAtualFormatada() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
        return sdf.format(Calendar.getInstance().getTime());
    }
	
}