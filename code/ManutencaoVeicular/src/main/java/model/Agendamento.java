

package model;

import service.GeradorId;

import java.time.LocalDate;
import java.util.Date;

public class Agendamento {
    private LocalDate data;
    private int idAgendamento;
    private Cliente cliente;
    private Veiculo veiculo;
    private Servico servico;
    private Integer id;

    public Agendamento() {
    }

    public Agendamento(Cliente cliente, Veiculo veiculo, Servico servico, LocalDate data) {
        this.idAgendamento = idAgendamento;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.servico = servico;
        this.data = data;
        this.id = GeradorId.getProximoId();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
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
