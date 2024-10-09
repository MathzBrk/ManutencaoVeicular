package controller;

import exception.ValidationException;
import model.Cliente;
import service.ClienteService;
import validation.ClienteValidator;

import java.util.Scanner;

public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    public void menuCliente() throws ValidationException {
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
                    scanner.nextLine();
                    System.out.println("Digite o nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.println("Digite email do Cliente: ");
                    String emailCliente = scanner.nextLine();

                    System.out.println("Digite o telefone do Cliente: ");
                    String telefone = scanner.nextLine();

                    System.out.println("Digite o cpf do Cliente: ");
                    String cpf = scanner.nextLine();

                    Cliente cliente = new Cliente(nomeCliente, emailCliente, telefone, cpf);
                    ClienteValidator.validar(cliente);
                    clienteService.adicionarCliente(cliente);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Digite o cpf do cliente que deseja consultar: ");
                    cpf = scanner.nextLine(); // Agora será lido corretamente

                    Cliente cliente1 = clienteService.consultarPorCpf(cpf);
                    if (cliente1 != null) {
                        System.out.println(cliente1);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;


                case 3:
                    scanner.nextLine();
                    System.out.print("Digite o CPF do cliente que deseja alterar: ");
                    cpf = scanner.nextLine();

                    System.out.print("Digite o novo nome do Cliente: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Digite o novo email do Cliente: ");
                    String novoEmail = scanner.nextLine();

                    System.out.print("Digite o novo telefone do Cliente: ");
                    String novoTelefone = scanner.nextLine();

                    clienteService.atualizarClientePorCpf(cpf, novoNome, novoEmail, novoTelefone);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Digite o cpf do cliente que deseja remover: ");
                    cpf = scanner.nextLine();

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
