package controller;

import java.util.Scanner;

public class MenuController {

    ClienteController clienteController = new ClienteController();
    VeiculoController veiculoController = new VeiculoController();
    ServicoController servicoController = new ServicoController();
    AgendamentoController agendamentoController = new AgendamentoController();

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("===== Sistema de Agendamento de Manutenção Veicular =====");
            System.out.println("1. Gestão de Clientes");
            System.out.println("2. Gestão de Veículos");
            System.out.println("3. Gestão de Serviços");
            System.out.println("4. Agendamentos e Status");
            System.out.println("5. Gerar PDF Excel");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    clienteController.menuCliente();
                    break;
                case 2:
                    veiculoController.menuVeiculos();
                    break;
                case 3:
                    servicoController.menuServicos();
                    break;
                case 4:
                    agendamentoController.menuAgendamentos();
                    break;
                case 5:
                    //gerarPDF();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);

        scanner.close();
    }
}