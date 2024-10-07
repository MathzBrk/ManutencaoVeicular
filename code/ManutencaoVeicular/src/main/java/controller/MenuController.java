package controller;

import exception.ValidationException;
import exporter.AgendamentoExcelExporter;
import service.AgendamentoService;

import java.util.Scanner;

public class MenuController {

    private ClienteController clienteController = new ClienteController();
    private VeiculoController veiculoController = new VeiculoController();
    private ServicoController servicoController = new ServicoController();
    private AgendamentoController agendamentoController = new AgendamentoController(clienteController.getClienteService(), veiculoController.getVeiculoService(), servicoController.getServicoService());
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

        if (agendamentoService != null && !agendamentoService.listarAgendamentos().isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome que deseja colocar no arquivo Excel (sem a extensão .xlsx): ");
            String nomeArquivo = scanner.nextLine().trim();

            if (!nomeArquivo.isEmpty()) {
                String caminhoArquivo = nomeArquivo + ".xlsx";
                agendamentoExcelExporter.exportarAgendamentosParaExcel(agendamentoService.listarAgendamentos(), caminhoArquivo);
                System.out.println("Arquivo Excel gerado com sucesso: " + caminhoArquivo);
            } else {
                System.out.println("Nome do arquivo inválido. Por favor, tente novamente.");
            }
        } else {
            System.out.println("Não há agendamentos disponíveis ou não foi possível acessar a lista.");
        }
    }
}

