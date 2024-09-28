

package model;

import java.time.LocalDate;

public class Agendamento {
    private LocalDate data;
    private String descricao;
    private int idAgendamento;
    private Cliente cliente;
    private Veiculo veiculo;

    public Agendamento() {
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

    @Override
    public String toString() {
        return "Agendamento{" +
                "idAgendamento=" + idAgendamento +
                ", usuario=" + cliente +
                ", veiculo=" + veiculo +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
}
