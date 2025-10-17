package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    public static int getRowCount(String sheetName) {
        try {
            FileInputStream fis = new FileInputStream("./testData/TestData.xlsx");
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheet(sheetName);
            return sheet.getPhysicalNumberOfRows();
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getData(String sheetName, int rowNum, int colNum) {
        String cellValue = "";
        try {
            FileInputStream fis = new FileInputStream("./testData/TestData.xlsx");
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheet(sheetName);
            Cell cell = sheet.getRow(rowNum).getCell(colNum);
            cellValue = switch (cell.getCellType()) {
                case STRING -> cell.getStringCellValue();
                case NUMERIC -> String.valueOf((long) cell.getNumericCellValue());
                default -> "";
            };

            wb.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellValue;
    }
}