package controller;

import exporter.AgendamentoExcelExporter;
import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.Veiculo;
import service.AgendamentoService;

import java.time.LocalDate;

public class SimulacaoController {

    public static void main(String[] args) {
        AgendamentoService agendamentoService = new AgendamentoService();

        gerarAgendamentosExemplo(agendamentoService);

        AgendamentoExcelExporter agendamentoExcelExporter = new AgendamentoExcelExporter();
        String caminhoArquivo = "agendamentos_simulados.xlsx";
        agendamentoExcelExporter.exportarAgendamentosParaExcel(agendamentoService.listarAgendamentos(), caminhoArquivo);
    }


    private static void gerarAgendamentosExemplo(AgendamentoService agendamentoService) {

        Cliente cliente1 = new Cliente("João Silva", "joao@gmail.com", "(11) 91234-5678", "123.456.789-00");
        Cliente cliente2 = new Cliente("Maria Oliveira", "maria@gmail.com", "(11) 97654-3210", "987.654.321-00");

        Veiculo veiculo1 = new Veiculo("Ford", "Fiesta", 2015, "ABC-1234");
        Veiculo veiculo2 = new Veiculo("Chevrolet", "Onix", 2018, "XYZ-5678");

        Servico servico1 = new Servico("Troca de óleo", 120.0);
        Servico servico2 = new Servico("Alinhamento e balanceamento", 200.0);

        Agendamento agendamento1 = new Agendamento(cliente1, veiculo1, servico1, LocalDate.of(2024, 10, 10));
        Agendamento agendamento2 = new Agendamento(cliente2, veiculo2, servico2, LocalDate.of(2024, 10, 15));

        agendamentoService.adicionarAgendamento(agendamento1);
        agendamentoService.adicionarAgendamento(agendamento2);
    }
}
