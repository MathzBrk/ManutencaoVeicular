import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Nome do arquivo Excel a ser criado
        String fileName = "test-poi.xlsx";

        // Criação de um workbook (arquivo Excel)
        try (Workbook workbook = new XSSFWorkbook()) {
            // Criação de uma planilha
            Sheet sheet = workbook.createSheet("Sheet1");

            // Criação de uma linha e células
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("Hello, Apache POI!");

            // Salvando o arquivo Excel
            try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
                workbook.write(fileOut);
            }

            System.out.println("Arquivo Excel criado com sucesso: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao criar o arquivo Excel.");
        }
    }
}
