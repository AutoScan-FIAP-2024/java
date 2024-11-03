package br.com.fiap.beans;

public class Mecanica {
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String logradouro;

    public Mecanica() {
    	
    }

    public Mecanica(String cep, String bairro, String cidade, String estado, String logradouro) {
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public String toString() {
        return "CentroAutomotivo [CEP=" + cep + ", Bairro=" + bairro + ", Cidade=" + cidade 
                + ", Estado=" + estado + ", Logradouro=" + logradouro + "]";
    }
}
