package controller;

import java.util.Scanner;

public class MenuController {

    Scanner scanner = new Scanner(System.in);
    int option;

    public void displayMenu() {

        do {
            System.out.println("===== Sistema de Agendamento de Manutenção Veicular =====");
            System.out.println("1. Gestão de Usuários");
            System.out.println("2. Gestão de Veículos");
            System.out.println("3. Gestão de Serviços");
            System.out.println("4. Agendamentos e Status");
            System.out.println("5. Gerar Relatórios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    menuUsuarios();
                    break;
                case 2:
                    menuVeiculos();
                    break;
                case 3:
                    menuServicos();
                    break;
                case 4:
                    menuAgendamentos();
                    break;
                case 5:
                    //gerarRelatorio();
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

    public void menuUsuarios() {

        do {
            System.out.println("===== Gestão de Usuários =====");
            System.out.println("1. Adicionar Usuário");
            System.out.println("2. Consultar Usuário");
            System.out.println("3. Atualizar Usuário");
            System.out.println("4. Remover Usuário");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    //adicionarUsuario();
                    break;
                case 2:
                    //consultarUsuario();
                    break;
                case 3:
                    //atualizarUsuario();
                    break;
                case 4:
                    //removerUsuario();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    displayMenu();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
    }

    public void menuVeiculos() {

        do {
            System.out.println("===== Gestão de Veículos =====");
            System.out.println("1. Adicionar Veículo");
            System.out.println("2. Consultar Veículo");
            System.out.println("3. Atualizar Veículo");
            System.out.println("4. Remover Veículo");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    //adicionarVeiculo();
                    break;
                case 2:
                    //buscarVeiculo();
                    break;
                case 3:
                    //atualizarVeiculo();
                    break;
                case 4:
                    //removerVeiculo();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    displayMenu();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
    }

    public void menuServicos() {
        do {
            System.out.println("===== Gestão de Serviços =====");
            System.out.println("1. Adicionar Serviço");
            System.out.println("2. Consultar Serviço");
            System.out.println("3. Atualizar Serviço");
            System.out.println("4. Remover Serviço");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    //adicionarServico();
                    break;
                case 2:
                    //consultarServico();
                    break;
                case 3:
                    //atualizarServico();
                    break;
                case 4:
                    //removerServico();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    displayMenu();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
    }

    public void menuAgendamentos() {

        do {
            System.out.println("===== Gestão de Agendamentos e Status =====");
            System.out.println("1. Adicionar Agendamento");
            System.out.println("2. Consultar Agendamento");
            System.out.println("3. Atualizar Agendamento");
            System.out.println("4. Remover Agendamento");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    //adicionarAgendamento();
                    break;
                case 2:
                    //consultarAgendamento();
                    break;
                case 3:
                    //atualizarAgendamento();
                    break;
                case 4:
                    //removerAgendamento();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    displayMenu();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
    }
}

