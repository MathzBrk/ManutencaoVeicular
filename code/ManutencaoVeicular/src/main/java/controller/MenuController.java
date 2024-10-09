package controller;

import exception.ValidationException;
import exporter.AgendamentoExcelExporter;
import service.AgendamentoService;
import service.ClienteService;
import service.ServicoService;
import service.VeiculoService;

import java.util.Scanner;

public class MenuController {

    private ClienteService clienteService;
    private VeiculoService veiculoService;
    private ServicoService servicoService;
    private AgendamentoService agendamentoService;

    private ClienteController clienteController;
    private VeiculoController veiculoController;
    private ServicoController servicoController;
    private AgendamentoController agendamentoController;

    public MenuController() {
        this.clienteService = new ClienteService();
        this.veiculoService = new VeiculoService();
        this.servicoService = new ServicoService();
        this.agendamentoService = new AgendamentoService();

        this.clienteController = new ClienteController(clienteService);
        this.veiculoController = new VeiculoController(veiculoService);
        this.servicoController = new ServicoController(servicoService);
        this.agendamentoController = new AgendamentoController(clienteService, veiculoService, servicoService, agendamentoService);
    }
    private AgendamentoExcelExporter agendamentoExcelExporter = new AgendamentoExcelExporter();

    public void displayMenu() throws ValidationException {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("===== Sistema de Agendamento de Manutenção Veicular =====");
            System.out.println("1. Gestão de Clientes");
            System.out.println("2. Gestão de Veículos");
            System.out.println("3. Gestão de Serviços");
            System.out.println("4. Agendamentos e Status");
            System.out.println("5. Gerar arquivo Excel");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

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
                    gerarArquivoExcel();
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

    private void gerarArquivoExcel() {
        AgendamentoService agendamentoService = agendamentoController.getAgendamentoService();

        if (agendamentoService != null && !agendamentoService.retornarAgendamentos().isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome que deseja colocar no arquivo Excel (sem a extensão .xlsx): ");
            String nomeArquivo = scanner.nextLine().trim();

            if (!nomeArquivo.isEmpty()) {
                String caminhoArquivo = nomeArquivo + ".xlsx";
                agendamentoExcelExporter.exportarAgendamentosParaExcel(agendamentoService.retornarAgendamentos(), caminhoArquivo);
                System.out.println("Arquivo Excel gerado com sucesso: " + caminhoArquivo);
            } else {
                System.out.println("Nome do arquivo inválido. Por favor, tente novamente.");
            }
        } else {
            System.out.println("Não há agendamentos disponíveis ou não foi possível acessar a lista.");
        }
    }
}

