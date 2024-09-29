

package model;

import java.time.LocalDate;

public class Agendamento {
    private LocalDate data;
    private int idAgendamento;
    private Cliente cliente;
    private Veiculo veiculo;
    private Servico servico;

    public Agendamento() {
    }

    public Agendamento(int idAgendamento, Cliente cliente, Veiculo veiculo, Servico servico, LocalDate data) {
        this.idAgendamento = idAgendamento;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.servico = servico;
        this.data = data;
    }

    public Cliente getUsuario() {
        return cliente;
    }

    public void setUsuario(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "idAgendamento=" + idAgendamento +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", data=" + data +
                ", servico=" + servico.getDescricao() +
                '}';
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
}
