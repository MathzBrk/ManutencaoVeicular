package model;

public class Servico {

    private String descricao;
    private int idServico;

    public Servico(String descricao, int idServico) {
        this.descricao = descricao;
        this.idServico = idServico;
    }

    public Servico() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }
}
