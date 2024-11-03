package br.com.fiap.beans;

import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class PecaMecanica {
	
    private String nome;
    private String tipo;
    private int quantidade;
    
    public PecaMecanica() {
    	
    }
    
    public PecaMecanica(String nome, String tipo, int quantidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método para exibir as peças
    @SuppressWarnings("rawtypes")
	public void escolha(int qtd) {
    	Object[] opcoes = {
    		    "Pastilhas de freio (" + qtd + ")",
    		    "Discos de freio (" + qtd + ")",
    		    "Amortecedores (" + qtd + ")",
    		    "Filtros de óleo (" + qtd + ")",
    		    "Filtros de ar (" + qtd + ")",
    		    "Filtros de combustível (" + qtd + ")",
    		    "Bateria (" + qtd + ")",
    		    "Correia dentada (" + qtd + ")",
    		    "Correia do alternador (" + qtd + ")",
    		    "Velas de ignição (" + qtd + ")",
    		    "Cabos de vela (" + qtd + ")",
    		    "Bobina de ignição (" + qtd + ")",
    		    "Embreagem (" + qtd + ")",
    		    "Rolamentos de roda (" + qtd + ")",
    		    "Junta homocinética (" + qtd + ")",
    		    "Braço oscilante (bandeja de suspensão) (" + qtd + ")",
    		    "Pivô de suspensão (" + qtd + ")",
    		    "Coxim do motor (" + qtd + ")",
    		    "Radiador (" + qtd + ")",
    		    "Válvula termostática (" + qtd + ")",
    		    "Sensor de temperatura (" + qtd + ")",
    		    "Sensor de oxigênio (sonda lambda) (" + qtd + ")",
    		    "Injetor de combustível (" + qtd + ")",
    		    "Bomba de combustível (" + qtd + ")",
    		    "Bomba d'água (" + qtd + ")",
    		    "Terminais de direção (" + qtd + ")",
    		    "Barras estabilizadoras (" + qtd + ")",
    		    "Kit de reparo de suspensão (" + qtd + ")",
    		    "Cilindro mestre do freio (" + qtd + ")",
    		    "Ventoinha do radiador (" + qtd + ")"
    		};

        @SuppressWarnings("unchecked")
		JComboBox listaopcao = new JComboBox(opcoes);
        listaopcao.setSelectedIndex(0);
        JOptionPane.showMessageDialog(null, listaopcao, "Peças disponíveis", JOptionPane.QUESTION_MESSAGE);
 
    }
    
    public int subQuantidade(String itemSelecionado) throws ClassNotFoundException, SQLException {
    	int qtd = 100;
    	escolha(qtd);
    	return qtd--;       
    	
    }

    
  
}

