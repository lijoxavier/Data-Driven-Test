package datadriventest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\user\\\\\\\\\\\\\\\\Desktop\\\\\\\\\\\\\\\\New folder\\\\\\\\\\\\\\\\seleniumpractise\\\\\\\\\\\\\\\\book2.xlsx");
		//FileInputStream is used for reading the excel sheet
		//FileOutStream is used for writing the excel sheet
		XSSFWorkbook workbook =new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		System.out.println(sheet.getLastRowNum()); //returns the row count
		int rowcount= sheet.getLastRowNum();
		System.out.println(sheet.getRow(0).getLastCellNum()); //returns cell count/column count
		for(int i=0;i<=rowcount;i++) {
			XSSFRow row= sheet.getRow(i);
			int colcount=sheet.getRow(i).getLastCellNum();
			for(int j=0;j<colcount;j++) {
				String value=row.getCell(j).toString();
				System.out.print(" "+value);
			}
			System.out.println();
		}
		

	}

}
