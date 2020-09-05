package testAppworkSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datadrive {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "F://GIT//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://creds.appwrk.com/sign-in"); //open URL
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@class='MuiTypography-root MuiLink-root MuiLink-underlineHover MuiTypography-h6 MuiTypography-colorPrimary']")).click();
		
		FileInputStream file=new FileInputStream("F://GIT//New folder//testAppworkSelenium//src//test//data.xlsx"); //open file
        XSSFWorkbook workbook=new XSSFWorkbook(file); //open workbook
        XSSFSheet sheet=workbook.getSheet("sheet1");  //open sheet
        
        int rowcount=sheet.getLastRowNum();
        int colcount=sheet.getRow(0).getLastCellNum();
        System.out.println(colcount);
        for(int i=1;i<=rowcount;i++) {
        	XSSFRow row=sheet.getRow(i);
        	String firstname=row.getCell(0).toString();
        	String lastname=row.getCell(1).toString();
        	String email=row.getCell(2).toString();
        	String password=row.getCell(3).toString();
        	

    		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstname);
    		driver.findElement((By.xpath("//input[@name='lastName']"))).sendKeys(lastname);
    		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    		
    		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    		driver.findElement(By.xpath("//input[@name='policy']")).click();
    		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    		driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();
        }
        
	}

}
