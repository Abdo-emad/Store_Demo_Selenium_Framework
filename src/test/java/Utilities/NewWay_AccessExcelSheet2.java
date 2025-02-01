package Utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewWay_AccessExcelSheet2 {

    public static Object[][] getData(String testCaseName) throws IOException {
        String path = System.getProperty("user.dir") + "/src/main/resources/UserRegistrationData2.xlsx";
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        List<Object[]> dataList = new ArrayList<>(); // To store all rows of data

        // Loop through sheets in the workbook
        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                // Get the header row to identify the TestCases column
                Iterator<Row> rows = sheet.iterator(); // Sheet is a collection of rows
                Row headerRow = rows.next(); // First row (header)
                int testCaseColumnIndex = -1;

                // Find the "TestCases" column
                Iterator<Cell> headerCells = headerRow.cellIterator();
                int colIndex = 0;
                while (headerCells.hasNext()) {
                    Cell cell = headerCells.next();
                    if (cell.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        testCaseColumnIndex = colIndex;
                        break;
                    }
                    colIndex++;
                }

                if (testCaseColumnIndex == -1) {
                    throw new IllegalArgumentException("TestCases column not found in the sheet.");
                }

                // Scan rows for the specified test case
                while (rows.hasNext()) {
                    Row currentRow = rows.next();
                    Cell testCaseCell = currentRow.getCell(testCaseColumnIndex);

                    // Check if the row matches the testCaseName
                    if (testCaseCell != null && testCaseCell.getStringCellValue().equalsIgnoreCase(testCaseName)) {
                        List<Object> rowData = new ArrayList<>();

                        // Collect all cells in the row except the TestCases column
                        for (int j = 1; j < currentRow.getLastCellNum(); j++) {
                            Cell cell = currentRow.getCell(j);
                            if (cell == null) {
                                rowData.add(""); // Handle empty cells
                            } else if (cell.getCellType() == CellType.STRING) {
                                rowData.add(cell.getStringCellValue());
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                rowData.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
                            } else {
                                rowData.add(""); // Handle other cell types as empty
                            }
                        }

                        // Convert rowData to an array and add it to dataList
                        dataList.add(rowData.toArray());
                    }
                }
            }
        }

        workbook.close(); // Close workbook to release resources
        fis.close();

        // Convert dataList to Object[][]
        Object[][] data = new Object[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }

        return data;
    }





}


