

package model;

import java.time.LocalDate;
import java.util.Date;

public class Agendamento {
    private Date data;
    private int idAgendamento;
    private Cliente cliente;
    private Veiculo veiculo;
    private Servico servico;

    public Agendamento() {
    }

    public Agendamento(int idAgendamento, Cliente cliente, Veiculo veiculo, Servico servico, Date data) {
        this.idAgendamento = idAgendamento;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.servico = servico;
        this.data = data;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
