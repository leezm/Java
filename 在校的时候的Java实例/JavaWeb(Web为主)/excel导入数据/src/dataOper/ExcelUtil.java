package dataOper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtil {
	public static void fillExcelData(ResultSet rs,Workbook wb,String[] headers) throws Exception{
		int rowIndex = 0;
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(rowIndex++);
		for(int i = 0;i < headers.length;i++){
			row.createCell(i).setCellValue(headers[i]);
		}
		while(rs.next()){
			row = sheet.createRow(rowIndex++);
			for(int i = 0;i < headers.length;i++){
				row.createCell(i).setCellValue(rs.getObject(i+1).toString());
			}
		}
	}
	
	public static Workbook fillExcelDataTemplate(ResultSet rs,String TemplateFileName) throws Exception{
		int rowIndex = 1;
		InputStream is = ExcelUtil.class.getResourceAsStream(""+TemplateFileName);
		POIFSFileSystem ps = new POIFSFileSystem(is);
		HSSFWorkbook wb = new HSSFWorkbook(ps);
		Sheet sheet = wb.getSheetAt(0);
		int colNum = sheet.getRow(0).getLastCellNum();
		while(rs.next()){
			Row row = sheet.createRow(rowIndex++);
			for(int i = 0;i < colNum;i++){
				row.createCell(i).setCellValue(rs.getObject(i+1).toString());
			}
		}
		return wb;
		
		
	}
}