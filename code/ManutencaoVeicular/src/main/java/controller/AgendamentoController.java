package controller;

import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.Veiculo;
import service.*;

import java.time.LocalDate;
import java.util.Scanner;

public class AgendamentoController {

    AgendamentoService agendamentoService = new AgendamentoService();
    Cliente cliente;
    Veiculo veiculo;
    Servico servico;

    public void menuAgendamentos() {
        Scanner scanner = new Scanner(System.in);
        int option;
        ClienteService clienteService = new ClienteService();
        VeiculoService veiculoService = new VeiculoService();
        ServicoService servicoService = new ServicoService();

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
                    scanner.nextLine();
                    cliente = clienteService.consultarPorCpf(cpf);

                    System.out.println("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    veiculo = veiculoService.buscarVeiculo(placa);

                    int novoID = GeradorId.getProximoId();
                    System.out.println("Id do agendamento: " + novoID);

                    System.out.println("Digite a data do agendamento (yyyy-mm-dd): ");
                    String dataAgendamento = scanner.nextLine();
                    LocalDate data = LocalDate.parse(dataAgendamento);

                    Agendamento agendamento = new Agendamento(cliente, veiculo, servico, data);
                    agendamentoService.adicionarAgendamento(agendamento);
                    System.out.println("Agendamento adicionado com sucesso.");

                    break;
                case 2:
                    System.out.println("Digite o ID do agendamento que deseja buscar: ");
                    int idAgendamento = scanner.nextInt();
                    scanner.nextLine();
                    agendamentoService.buscarAgendamentoPorId(idAgendamento);
                    break;
                case 3:
                    System.out.println("Digite o id do agendamento que deseja atualizar: ");
                    idAgendamento = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o CPF do cliente: ");
                    cpf = scanner.nextLine();
                    cliente = clienteService.consultarPorCpf(cpf);

                    System.out.println("Digite a placa do veículo: ");
                    placa = scanner.nextLine();
                    veiculo = veiculoService.buscarVeiculo(placa);

                    System.out.println("Digite o ID do serviço: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    servico = servicoService.buscarServicoPorId(id);

                    System.out.println("Digite a nova data do agendamento (yyyy-mm-dd): ");
                    dataAgendamento = scanner.nextLine();
                    data = LocalDate.parse(dataAgendamento);

                    Agendamento agendamentoAtualizado = new Agendamento(cliente, veiculo, servico, data);
                    agendamentoAtualizado.setIdAgendamento(id);

                    agendamentoService.atualizarAgendamento(id, agendamentoAtualizado);
                    System.out.println("Agendamento atualizado com sucesso.");

                    break;
                case 4:
                    System.out.println("Digite o ID do agendamento que deseja remover: ");
                    idAgendamento = scanner.nextInt();
                    scanner.nextLine();
                    agendamentoService.removerAgendamento(idAgendamento);
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
