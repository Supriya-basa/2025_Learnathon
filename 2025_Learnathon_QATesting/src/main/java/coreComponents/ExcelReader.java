package coreComponents;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    private Workbook workbook;

    public ExcelReader(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getRowData(String sheetName, String scenarioName) {
        Map<String, String> data = new HashMap<>();
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist");
        }

        int scenarioColumnIndex = 0;
        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equalsIgnoreCase("Scenario")) {
                scenarioColumnIndex = cell.getColumnIndex();
                break;
            }
        }

        for (Row row : sheet) {
            Cell scenarioCell = row.getCell(scenarioColumnIndex);
            if (scenarioCell != null && scenarioCell.getStringCellValue().equalsIgnoreCase(scenarioName)) {
                for (Cell cell : row) {
                    String header = headerRow.getCell(cell.getColumnIndex()).getStringCellValue();
                    String value = cell.getStringCellValue();
                    data.put(header, value);
                }
                break;
            }
        }
        return data;
    }
}