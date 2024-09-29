package model;

public class Servico {

    private String descricao;
    private int idServico;
    private boolean finalizado;
    private double preco;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Servico(String descricao, double preco, int idServico) {
        this.descricao = descricao;
        this.idServico = idServico;
        this.finalizado = false;
        this.preco = preco;
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
                ", preco=" + preco +
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
