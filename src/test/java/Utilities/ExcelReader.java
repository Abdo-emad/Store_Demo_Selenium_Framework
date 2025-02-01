package Utilities;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public  Object[][] AccessExcelSheet() throws IOException {
        String filePath = System.getProperty("user.dir")+"./src/main/resources/UserRegistrationData.xlsx";
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        int numberOfSheets = workbook.getNumberOfSheets();
        String[][] arrayExcelData = null;
        for (int i = 0; i < numberOfSheets; i++) {
            arrayExcelData = null;
            if (workbook.getSheetName(i).equalsIgnoreCase("data")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                int numberOfRows = (sheet.getLastRowNum() + 1);
                int numberOfColumns = 5;
                arrayExcelData = new String[numberOfRows][numberOfColumns];
                for (int k = 0; k < numberOfRows; k++) {
                    for (int j = 0; j < numberOfColumns; j++) {
                        XSSFRow row = sheet.getRow(k);
                        arrayExcelData[k][j] = row.getCell(j).toString();
                    }
                }


            }

        }
        workbook.close();
        return arrayExcelData;
    }
}
