package datadriventest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Table.Cell;

public class RegisterationTest {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\user\\\\\\\\eclipse-workspace\\\\\\\\JavaProject\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.linkText("Register")).click();
		FileInputStream file=new FileInputStream("C:\\\\Users\\\\user\\\\Desktop\\\\New folder\\\\seleniumpractise\\\\book2.xlsx");
		XSSFWorkbook workbook =new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet("Sheet2");
		System.out.println(sheet);
		int rowNum=sheet.getLastRowNum();
		String first_name,last_name,gender="",email;
		String password;
		
			for(int i=1;i<=rowNum;i++) {
//				try {
				//reading value
				first_name=sheet.getRow(i).getCell(0).getStringCellValue();
				last_name=sheet.getRow(i).getCell(1).getStringCellValue();
				gender=sheet.getRow(i).getCell(11).getStringCellValue();
				email=sheet.getRow(i).getCell(3).getStringCellValue();
				password=sheet.getRow(i).getCell(10).getStringCellValue();
				 
				
				//radio button
				if(!driver.findElement(By.id("gender-female")).isSelected()) {
					if(driver.findElement(By.cssSelector("label[for='gender-female']")).getText().equalsIgnoreCase(gender)) {
						driver.findElement(By.id("gender-female")).click();
					}
							
				}
				if(!driver.findElement(By.id("gender-male")).isSelected()) {
					if(driver.findElement(By.cssSelector("label[for='gender-male']")).getText().equalsIgnoreCase(gender)) {
						driver.findElement(By.id("gender-male")).click();
					}
				}
				else {System.out.println("logical problem");}
				
				//contact information
				driver.findElement(By.id("FirstName")).sendKeys(first_name);
				driver.findElement(By.id("LastName")).sendKeys(last_name);
				driver.findElement(By.name("Email")).sendKeys(email);
				driver.findElement(By.name("Password")).sendKeys(password);
				driver.findElement(By.name("ConfirmPassword")).sendKeys(password);	
//				driver.findElement(By.name("ConfirmPassword")).sendKeys(String.valueOf(password));//password numerical anel convert to string 	
				
				//dropdownlist -date of birth 
				Select day=new Select(driver.findElement(By.name("DateOfBirthDay")));
				day.selectByVisibleText("5");
				
				Select month=new Select(driver.findElement(By.name("DateOfBirthMonth"))); 
				month.selectByVisibleText("March");
				
			
			
	//			driver.findElement(By.id("Newsletter")).clear();
				
				driver.findElement(By.id("register-button")).click();
				driver.navigate().back();
				
//				}catch(UnhandledAlertException e) {
//					Alert al= driver.switchTo().alert();
////					al.dismiss();
//				}
			
			}
		
		driver.close();
		
		

    }

}
