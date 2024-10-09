package controller;

import exception.ValidationException;
import model.Veiculo;
import service.VeiculoService;
import validation.VeiculoValidator;

import java.util.Scanner;

public class VeiculoController {

    VeiculoService veiculoService = new VeiculoService();

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    public VeiculoService getVeiculoService() {
        return veiculoService;
    }

    public void setVeiculoService(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    public void menuVeiculos() throws ValidationException {
        Scanner scanner = new Scanner(System.in);
        int option;

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
                    scanner.nextLine();
                    System.out.println("Digite a marca do veiculo que deseja adicionar: ");
                    String marca = scanner.nextLine();

                    System.out.println("Digite o modelo do veiculo: ");
                    String modelo = scanner.nextLine();

                    System.out.println("Digite o ano do veiculo: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite a placa do veiculo: ");
                    String placa = scanner.nextLine().toUpperCase();

                    Veiculo veiculo = new Veiculo(marca, modelo, ano, placa);
                    VeiculoValidator.validar(veiculo);
                    veiculoService.adicionarVeiculo(veiculo);
                    break;

                case 2:
                    scanner.nextLine();
                    System.out.println("Digite a placa do veiculo que deseja consultar: ");
                    placa = scanner.nextLine();

                    Veiculo veiculo1 = veiculoService.buscarVeiculo(placa);

                    if (veiculo1 != null) {
                        System.out.println(veiculo1);
                    }else {
                        System.out.println("Veiculo não encontrado");
                    }

                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Digite a placa do veiculo que deseja alterar: ");
                    placa = scanner.nextLine();

                    System.out.println("Digite a marca do veiculo que deseja alterar: ");
                    marca = scanner.nextLine();

                    System.out.println("Digite o modelo do veiculo que deseja alterar: ");
                    modelo = scanner.nextLine();

                    System.out.println("Digite o ano do veiculo que deseja alterar: ");
                    ano = scanner.nextInt();

                    Veiculo veiculoAtualizado = new Veiculo(marca, modelo, ano, placa);
                    VeiculoValidator.validar(veiculoAtualizado);
                    veiculoService.atualizarVeiculo(placa, veiculoAtualizado);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Digite a placa do veiculo que deseja remover: ");
                    placa = scanner.nextLine();

                    veiculoService.removerVeiculo(placa);
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
