package controller;

import model.Servico;
import service.GeradorId;
import service.ServicoService;

import java.util.Scanner;

public class ServicoController {

    ServicoService servicoService = new ServicoService();

    public void menuServicos() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("===== Gestão de Serviços =====");
            System.out.println("1. Adicionar Serviço");
            System.out.println("2. Consultar Serviço");
            System.out.println("3. Atualizar Status do Serviço");
            System.out.println("4. Remover Serviço");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Digite a descrição do serviço: ");
                    String descricao = scanner.next();
                    scanner.nextLine();

                    System.out.print("Digite o preço do serviço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    Servico servico = new Servico(descricao, preco);
                    servicoService.adicionarServico(servico);

                    System.out.println("Serviço adicionado com ID: " + servico.getIdServico());
                    break;
                case 2:
                    System.out.println("Digite o ID do servico que deseja consultar: ");
                    int idServico = scanner.nextInt();
                    scanner.nextLine();

                    servicoService.buscarServicoPorId(idServico);
                    break;
                case 3:
                    System.out.println("Digite o ID do servico que deseja atualizar o Status: ");
                    int statusServico = scanner.nextInt();
                    scanner.nextLine();

                    servicoService.atualizarStatusServico(statusServico);
                    break;
                case 4:
                    System.out.println("Digite o ID do servico que deseja remover: ");
                    idServico = scanner.nextInt();
                    scanner.nextLine();

                    servicoService.removerServico(idServico);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    MenuController menuController = new MenuController();
                    menuController.displayMenu();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
    }
}
