package model;

public class Servico {

    private String descricao;
    private int idServico;
    private boolean finalizado;

    public Servico(String descricao, int idServico) {
        this.descricao = descricao;
        this.idServico = idServico;
        this.finalizado = false;
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

    @Override
    public String toString() {
        return "Servico{" +
                "idServico=" + idServico +
                ", descricao='" + descricao + '\'' +
                ", finalizado=" + finalizado +
                '}';
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }
}
