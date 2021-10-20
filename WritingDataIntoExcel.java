package datadriventest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file=new FileOutputStream("C:\\\\\\\\Users\\\\\\\\user\\\\\\\\Desktop\\\\\\\\New folder\\\\\\\\seleniumpractise\\\\\\\\book2.xlsx");
		XSSFWorkbook workbook =new XSSFWorkbook();
		XSSFSheet sheet= workbook.createSheet("Sheet3");
		for(int i=0;i<5;i++) {
			XSSFRow row= sheet.createRow(i);
			for(int j=0;j<3;j++) {
				row.createCell(j).setCellValue("xyz");
			}
		}
		workbook.write(file);
		file.close();
		System.out.println("writing data completed");
	

	}

}
