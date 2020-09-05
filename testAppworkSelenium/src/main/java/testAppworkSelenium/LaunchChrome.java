package testAppworkSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchChrome {
	
	public static void main (String[] args) {
		System.setProperty("webdriver.chrome.driver", "F://GIT//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://creds.appwrk.com/sign-in");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='MuiTypography-root MuiLink-root MuiLink-underlineHover MuiTypography-h6 MuiTypography-colorPrimary']")).click();
		
		WebElement firstName= driver.findElement(By.xpath("//input[@name='firstName']"));
		WebElement lastName=driver.findElement((By.xpath("//input[@name='lastName']")));
		WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		
		sendkeys(driver, firstName, 10, "Diwakar");
		sendkeys(driver, lastName, 5, "kumar");
		sendkeys(driver, email, 10, "diwakar@gmail.com");
		sendkeys(driver, password, 5, "password");
		
		driver.findElement(By.xpath("//input[@name='policy']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();
		String text=(driver.findElement(By.xpath("//div[@class='jss25']//div")).getText());
		String tagname=driver.findElement(By.xpath("//span[@class='MuiButton-label']")).getTagName();
		System.out.println(tagname);
		if(text.equals("Charles Bukowski")) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test is Fail");
		}
		
	}
		  public static void sendkeys(WebDriver driver,WebElement element, 
				  int timeout, String value ) {
				new WebDriverWait(driver,timeout)
						.until(ExpectedConditions.visibilityOf(element));	
				element.sendKeys(value);		
		  } 
}

		  /*clickOn(driver, policy, 5); clickOn(driver, signup,10);
		 /*
		 * WebElement policy=driver.findElement(By.xpath("//input[@name='policy']"));
		 * WebElement
		 * signup=driver.findElement(By.xpath("//span[@class='MuiButton-label']"));
		 */

	/*
	 * public static void clickOn(WebDriver driver,WebElement element, int timeout )
	 * { new WebDriverWait(driver,timeout)
	 * .until(ExpectedConditions.elementToBeClickable(element)); element.click(); }
	 */

