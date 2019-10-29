package testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderReadDataUsingExcel {
	@Test(dataProvider = "readData")
	public void printData(String username, String password) throws Exception {
		System.out.println("Username : " + username + " | Password : " + password);
	}

	@DataProvider
	public Object[][] readData() throws IOException {
		Object[][] arr = null;
		FileInputStream file = new FileInputStream("D:\\work\\testdata1.xls");
		HSSFWorkbook book = new HSSFWorkbook(file);
		HSSFSheet sheet = book.getSheet("credentials");
		int totalRows = sheet.getLastRowNum();
		for (int i = 1; i <= totalRows; i++) {
			Row row = sheet.getRow(i);
			int totalColumns = row.getLastCellNum();
			if (arr == null) {
				arr = new Object[totalRows][totalColumns];
			}
			for (int j = 0; j < totalColumns; j++) {
				Cell cell = row.getCell(j);
				if (cell.getCellTypeEnum() == CellType.STRING) {
					String value = cell.getStringCellValue();
					arr[i - 1][j] = value;
				} else {
					String value = NumberToTextConverter.toText(cell.getNumericCellValue());
					arr[i - 1][j] = value;
				}
			}
		}
		book.close();
		return arr;
	}
}
