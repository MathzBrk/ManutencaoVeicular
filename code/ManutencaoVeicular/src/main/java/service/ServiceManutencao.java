package service;

import model.Servico;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ServiceManutencao {

    private List<Servico> servicos;
    Scanner scanner = new Scanner(System.in);

    public ServiceManutencao() {
        this.servicos = new ArrayList<>();
    }

    // CREATE - Adicionar um novo serviço
    public void adicionarServico(Servico servico) {
        servicos.add(servico);
        System.out.println("Serviço adicionado: " + servico.getDescricao());
    }

    // READ - Listar todos os serviços
    public void listarServicos() {

        for(Servico servico : servicos) {
            System.out.println(servico);
        }
    }

    // READ - Buscar um serviço por ID
    public Optional<Servico> buscarServicoPorId(int id) {
        return servicos.stream()
                .filter(servico -> servico.getIdServico() == id)
                .findFirst();
    }

    // UPDATE - Atualizar um serviço existente
    public void atualizarStatusServico(int id) {
        Optional<Servico> servicoOptional = buscarServicoPorId(id);

        if (servicoOptional.isPresent()) {
            Servico servico = servicoOptional.get();
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


    // DELETE - Remover um serviço
    public void removerServico(int id) {
        Optional<Servico> servicoOptional = buscarServicoPorId(id);
        if (servicoOptional.isPresent()) {
            servicos.remove(servicoOptional.get());
            System.out.println("Serviço removido.");
        }else{
            System.out.println("Serviço não encontrado");
        }
    }
}

