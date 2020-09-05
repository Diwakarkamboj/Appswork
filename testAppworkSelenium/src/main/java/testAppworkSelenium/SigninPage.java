package testAppworkSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SigninPage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F://GIT//chromedriver.exe");  
		WebDriver driver=new ChromeDriver();   //Invoking browser
		driver.get("https://creds.appwrk.com/sign-in"); //open the url
		driver.manage().window().maximize(); //maximizing the window
		driver.findElement(By.name("email")).sendKeys("rajeshpanwar1717@gmail.com"); //enter the email
		driver.findElement(By.name("password")).sendKeys("password"); //enter the password
		driver.findElement(By.className("MuiButton-label")).click(); //click on sign in
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //need to wait for 10sec 
		driver.findElement(By.xpath("//p[contains(text(),'Users')]")).click();
		driver.navigate().forward();
		
		

	}

}
