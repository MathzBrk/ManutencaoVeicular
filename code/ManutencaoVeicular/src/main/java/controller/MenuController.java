package controller;

import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.Veiculo;
import service.AgendamentoService;
import service.ClienteService;
import service.ServiceManutencao;
import service.VeiculoService;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class MenuController {

    Scanner scanner = new Scanner(System.in);
    ClienteService clienteService = new ClienteService();
    VeiculoService veiculoService = new VeiculoService();
    ServiceManutencao servicoService = new ServiceManutencao();
    AgendamentoService agendamentoService = new AgendamentoService();
    int option;

    public void displayMenu() {

        do {
            System.out.println("===== Sistema de Agendamento de Manutenção Veicular =====");
            System.out.println("1. Gestão de Usuários");
            System.out.println("2. Gestão de Veículos");
            System.out.println("3. Gestão de Serviços");
            System.out.println("4. Agendamentos e Status");
            System.out.println("5. Gerar PDF Excel");
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
                    System.out.println("Digite o nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
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
                    clienteService.consultarPorCpf(cpf);
                    break;
                case 3:
                    System.out.println("Digite o cpf do cliente que deseja alterar: ");
                    cpf = scanner.nextLine();
                    //clienteService.
                    break;
                case 4:
                    System.out.println("Digite o cpf do cliente que deseja remover: ");
                    cpf = scanner.nextLine();
                    clienteService.removerClientePorCpf(cpf);
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
                    System.out.println("Digite a marca do veiculo que deseja adicionar: ");
                    String marca = scanner.nextLine();
                    System.out.println("Digite o modelo do veiculo: ");
                    String modelo = scanner.nextLine();
                    System.out.println("Digite o ano do veiculo");
                    int ano = scanner.nextInt();
                    System.out.println("Digite a placa do veiculo: ");
                    String placa = scanner.nextLine();
                    Veiculo veiculo = new Veiculo(marca, modelo, ano, placa);
                    veiculoService.adicionarVeiculo(veiculo);
                    break;
                case 2:
                    System.out.println("Digite a placa do veiculo que deseja consultar: ");
                    placa = scanner.nextLine();
                    veiculoService.buscarVeiculo(placa);
                    break;
                case 3:
                    System.out.println("Digite a placa do veiculo que deseja alterar: ");
                    placa = scanner.nextLine();
                    System.out.println("Digite a marca do veiculo que deseja alterar: ");
                    marca = scanner.nextLine();
                    System.out.println("Digite o modelo do veiculo que deseja alterar: ");
                    modelo = scanner.nextLine();
                    System.out.println("Digite o ano do veiculo que deseja alterar: ");
                    ano = scanner.nextInt();
                    Veiculo veiculoAtualizado = new Veiculo(marca, modelo, ano, placa);
                    veiculoService.atualizarVeiculo(placa, veiculoAtualizado);
                    break;
                case 4:
                    System.out.println("Digite a placa do veiculo que deseja remover: ");
                    placa = scanner.nextLine();
                    veiculoService.removerVeiculo(placa);
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
                    System.out.println("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    Cliente cliente = clienteService.consultarPorCpf();

                    System.out.println("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    Veiculo veiculo = veiculoService.buscarVeiculo();

                    System.out.println("Digite o ID do serviço: ");
                    int id = scanner.nextInt();
                    Servico servico = servicoService.buscarServicoPorId();

                    System.out.println("Digite a data do agendamento (yyyy-mm-dd): ");
                    String dataAgendamento = scanner.nextLine();
                    LocalDate data = LocalDate.parse(dataAgendamento);

                    int novoIdAgendamento = agendamentoService.gerarNovoId();
                    Agendamento agendamento = new Agendamento(novoIdAgendamento, cliente, veiculo, servico, data);
                    agendamentoService.adicionarAgendamento(agendamento);
                    System.out.println("Agendamento adicionado com sucesso.");

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