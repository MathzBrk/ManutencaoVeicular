package exporter;

import model.Agendamento;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AgendamentoExcelExporter {

    public void exportarAgendamentosParaExcel(List<Agendamento> agendamentos, String caminhoArquivo) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Agendamentos");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Data");
        headerRow.createCell(1).setCellValue("ID Agendamento");
        headerRow.createCell(2).setCellValue("Nome do Cliente");
        headerRow.createCell(3).setCellValue("Modelo do Veículo");
        headerRow.createCell(4).setCellValue("Serviço");
        headerRow.createCell(5).setCellValue("Preço do Serviço");


        int rowNum = 1;

        for (Agendamento agendamento : agendamentos) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(agendamento.getData().format(dateFormatter));
            row.createCell(1).setCellValue(agendamento.getIdAgendamento());
            row.createCell(2).setCellValue(agendamento.getCliente().getNome());
            row.createCell(3).setCellValue(agendamento.getVeiculo().getModelo());
            row.createCell(4).setCellValue(agendamento.getServico().getDescricao());
            row.createCell(5).setCellValue(agendamento.getServico().getPreco());
        }


        for (int i = 0; i < 6; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fileOut = new FileOutputStream(caminhoArquivo)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Arquivo Excel criado com sucesso: " + caminhoArquivo);
    }
}

