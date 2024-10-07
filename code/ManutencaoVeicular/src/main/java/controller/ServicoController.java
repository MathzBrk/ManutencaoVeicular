package controller;

import exception.ValidationException;
import model.Servico;
import service.GeradorId;
import service.ServicoService;
import validation.ServicoValidator;

import java.util.Scanner;

public class ServicoController {

    ServicoService servicoService = new ServicoService();

    public ServicoService getServicoService() {
        return servicoService;
    }

    public void menuServicos() throws ValidationException {
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
                    scanner.nextLine();
                    System.out.println("Digite a descrição do serviço: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Digite o preço do serviço: ");
                    String precoString = scanner.nextLine();
                    precoString = precoString.replace(",", ".");

                    try {
                        double preco = Double.parseDouble(precoString); // Converter para double
                        Servico servico = new Servico(descricao, preco);
                        ServicoValidator.validar(servico);
                        servicoService.adicionarServico(servico);
                        System.out.println("Serviço adicionado com sucesso!");
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: o preço inserido não é válido. Tente novamente.");
                    }

                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Digite o ID do servico que deseja consultar: ");
                    int idServico = scanner.nextInt();
                    scanner.nextLine();

                    Servico servico1 = servicoService.buscarServicoPorId(idServico);

                    if(servico1 != null){
                        System.out.println(servico1);
                    }else{
                        System.out.println("Erro ao buscar servico");
                    }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Digite o ID do servico que deseja atualizar o Status: ");
                    int statusServico = scanner.nextInt();
                    scanner.nextLine();

                    servicoService.atualizarStatusServico(statusServico);
                    break;
                case 4:
                    scanner.nextLine();
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
