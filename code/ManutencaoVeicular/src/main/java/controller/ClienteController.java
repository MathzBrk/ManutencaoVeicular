package controller;

import model.Cliente;
import service.ClienteService;

import java.util.Scanner;

public class ClienteController {

    ClienteService clienteService = new ClienteService();

    public void menuCliente() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("===== Gestão de Clientes =====");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Consultar Cliente");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Digite o nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    scanner.nextLine();

                    System.out.println("Digite email do Cliente: ");
                    String emailCliente = scanner.nextLine();

                    System.out.println("Digite o telefone do Cliente: ");
                    String telefone = scanner.nextLine();

                    System.out.println("Digite o cpf do Cliente: ");
                    String cpf = scanner.nextLine();

                    Cliente cliente = new Cliente(nomeCliente, emailCliente, telefone, cpf);
                    clienteService.adicionarCliente(cliente);
                    break;
                case 2:
                    System.out.println("Digite o cpf do cliente que deseja consultar: ");
                    cpf = scanner.nextLine();
                    scanner.nextLine();

                    clienteService.consultarPorCpf(cpf);
                    break;
                case 3:
                    System.out.print("Digite o CPF do cliente que deseja alterar: ");
                    cpf = scanner.nextLine();
                    scanner.nextLine();

                    System.out.print("Digite o novo nome do Cliente: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Digite o novo email do Cliente: ");
                    String novoEmail = scanner.nextLine();

                    System.out.print("Digite o novo telefone do Cliente: ");
                    String novoTelefone = scanner.nextLine();

                    clienteService.atualizarClientePorCpf(cpf, novoNome, novoEmail, novoTelefone);
                break;
                case 4:
                    System.out.println("Digite o cpf do cliente que deseja remover: ");
                    cpf = scanner.nextLine();
                    scanner.nextLine();

                    clienteService.removerClientePorCpf(cpf);
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
