package service;

import model.Servico;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicoService {

    private List<Servico> servicos;
    Scanner scanner = new Scanner(System.in);

    public ServicoService() {
        this.servicos = new ArrayList<>();
    }

    public void adicionarServico(Servico servico) {
        try{
            servicos.add(servico);
            System.out.println("Serviço adicionado: " + servico.getDescricao() + " ID: " + servico.getIdServico());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar servico: " + e.getMessage());
        }
    }

    public void listarServicos() {
        for (Servico servico : servicos) {
            System.out.println(servico);
        }
    }

    public Servico buscarServicoPorId(int id) {
        return servicos.stream()
                .filter(servico -> servico.getIdServico() == id)
                .findFirst()
                .orElse(null);
    }

    public void atualizarStatusServico(int id) {
        Servico servico = buscarServicoPorId(id);
        if (servico != null) {
            System.out.println("Você deseja marcar o serviço como: 1-finalizado 2-não finalizado");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                servico.setFinalizado(true);
                System.out.println("Status alterado com sucesso!");
            } else if (opcao == 2) {
                servico.setFinalizado(false);
                System.out.println("Status alterado com sucesso!");
            } else {
                System.out.println("Opção inválida! Por favor, selecione 1 ou 2.");
            }
        } else {
            System.out.println("Serviço não encontrado!!!");
        }
    }

    public void removerServico(int id) {
        Servico servico = buscarServicoPorId(id);
        if (servico != null) {
            servicos.remove(servico);
            System.out.println("Serviço removido.");
        } else {
            System.out.println("Serviço não encontrado");
        }
    }
}
