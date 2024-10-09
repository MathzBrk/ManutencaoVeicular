package controller;

import exception.ValidationException;
import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.Veiculo;
import service.*;
import validation.AgendamentoValidator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;

public class AgendamentoController {

    private AgendamentoService agendamentoService;
    private ClienteService clienteService;
    private ServicoService servicoService;
    private VeiculoService veiculoService;

    public AgendamentoController(ClienteService clienteService, VeiculoService veiculoService, ServicoService servicoService, AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
        this.clienteService = clienteService;
        this.veiculoService = veiculoService;
        this.servicoService = servicoService;
    }

    public AgendamentoService getAgendamentoService() {
        return agendamentoService;
    }

    public void setAgendamentoService(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    public void menuAgendamentos() throws ValidationException {
        Scanner scanner = new Scanner(System.in);
        int option;

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
                    scanner.nextLine();
                    System.out.println("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine().trim();
                    Cliente cliente = clienteService.consultarPorCpf(cpf);

                    if (cliente == null) {
                        System.out.println("Cliente não encontrado.");
                        break; // Sai do case se o cliente não for encontrado
                    }

                    System.out.println("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    Veiculo veiculo = veiculoService.buscarVeiculo(placa);

                    if (veiculo == null) {
                        System.out.println("Veículo não encontrado.");
                        break;
                    }

                    System.out.println("Digite a data do agendamento (yyyy-mm-dd): ");
                    String dataAgendamento = scanner.nextLine();
                    LocalDate data;

                    try {
                        data = LocalDate.parse(dataAgendamento);
                    } catch (DateTimeParseException e) {
                        System.out.println("Data inválida. Formato esperado: yyyy-mm-dd");
                        break; // Sai do case em caso de erro
                    }

                    System.out.println("Digite qual o id do serviço: ");
                    int id = scanner.nextInt();
                    Servico servico = servicoService.buscarServicoPorId(id);

                    if (servico == null) {
                        System.out.println("Serviço não encontrado.");
                        break;
                    }

                    Agendamento agendamento = new Agendamento(cliente, veiculo, servico, data);
                    AgendamentoValidator.validar(agendamento);
                    agendamentoService.adicionarAgendamento(agendamento);

                    break;
                case 2:
                    scanner.nextLine();
                    agendamentoService.listarAgendamentos();
                    System.out.println("Digite o ID do agendamento que deseja buscar: ");
                    int idAgendamento = scanner.nextInt();
                    scanner.nextLine();

                    Optional<Agendamento> agendamento1 = agendamentoService.buscarAgendamentoPorId(idAgendamento);

                    if (agendamento1.isPresent()) {
                        Agendamento agendamento2 = agendamento1.get();
                        System.out.println(agendamento2);
                    }else{
                        System.out.println("Agendamento não encontrado");
                    }
                    break;
                case 3:
                    scanner.nextLine();
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
                    id = scanner.nextInt();
                    scanner.nextLine();
                    servico = servicoService.buscarServicoPorId(id);

                    System.out.println("Digite a nova data do agendamento (yyyy-mm-dd): ");
                    dataAgendamento = scanner.nextLine();
                    data = LocalDate.parse(dataAgendamento);

                    Agendamento agendamentoAtualizado = new Agendamento(cliente, veiculo, servico, data);

                    agendamentoService.atualizarAgendamento(idAgendamento, agendamentoAtualizado);

                    break;
                case 4:
                    scanner.nextLine();
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
