package controller;

import model.Usuario;
import java.util.Scanner;

public class MenuController {

    Scanner scanner = new Scanner(System.in);
    Usuario user = new Usuario();

    public void displayMenu() {
        System.out.print("Insira o nome do usuario: ");
        user.setNome(scanner.nextLine());

        System.out.print("Insira a senha: ");
        user.setSenha(scanner.nextLine());

        int option;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Gerar Novo Serviço");
            System.out.println("2. Verificar Status do Agendamento");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    gerarNovoServico();
                    break;
                case 2:
                    verificarStatusAgendamento();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (option != 3);
    }

    private void gerarNovoServico() {
        System.out.println("Novo serviço gerado com sucesso!");

    }

    private void verificarStatusAgendamento() {
        System.out.println("Verificando status do agendamento...");

    }
}



