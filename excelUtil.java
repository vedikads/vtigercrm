package CommanUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtil {

	public Object getDataFromExcel;

	public String getDataFromExcel(String Sheetname,int Rownum ,int Cellnum) throws EncryptedDocumentException, IOException {
		
		FileInputStream files = new FileInputStream("src\\test\\resources\\Organizations.xlsx");
		
		Workbook wb = WorkbookFactory.create(files);
		Sheet sh = wb.getSheet(Sheetname);
		Row rw = sh.getRow(Rownum);
		Cell c1 = rw.getCell(Cellnum);
		String value = c1.getStringCellValue();
		return value;
		
		
		
		
		

	}

}
