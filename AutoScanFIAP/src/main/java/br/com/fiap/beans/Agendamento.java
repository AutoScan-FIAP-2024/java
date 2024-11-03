package br.com.fiap.beans;

public class Agendamento {
    private Cliente cliente;
    private Veiculo veiculo;
    private String dataAgendamento;
    private String status; // Ex: "Agendado", "Concluído", "Cancelado"

    public Agendamento(Cliente cliente, Veiculo veiculo, String dataAgendamento, String status) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataAgendamento = dataAgendamento;
        this.status = status;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void exibirDetalhesAgendamento() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Veículo: " + veiculo.getModelo());
        System.out.println("Data: " + dataAgendamento);
        System.out.println("Status: " + status);
    }
}
