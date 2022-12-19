package propertiesFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MercuryRegister {
	static WebDriver driver;
	Properties ps = new Properties();

	@BeforeSuite
	private void openPage() throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Requireds\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		
		  File f = new File("MercuryDetails.txt"); boolean createFile =
		  f.createNewFile(); //created .txt file in eclipse src folder
		  System.out.println(createFile);
		 

		FileInputStream fis = new FileInputStream("C:\\Users\\user\\Desktop\\Maven Workspace\\src\\MercuryDetails.txt");
//Above path is given of the folder created in src folder in eclipse(This package only).		
		ps.load(fis);

	}

	@BeforeTest
	private void openUrl() {
		driver.get(ps.getProperty("Url"));

	}

	@BeforeClass
	private void max() {
		driver.manage().window().maximize();

	}

	@Test
	private void registerPage() {
		driver.findElement(By.name("firstName")).sendKeys(ps.getProperty("FirstN"));
		driver.findElement(By.name("lastName")).sendKeys(ps.getProperty("LastN"));
		driver.findElement(By.name("phone")).sendKeys(ps.getProperty("Mobile"));
		driver.findElement(By.name("userName")).sendKeys(ps.getProperty("Id"));
		driver.findElement(By.name("address1")).sendKeys(ps.getProperty("Addr"));
		driver.findElement(By.name("city")).sendKeys(ps.getProperty("City"));
		driver.findElement(By.name("state")).sendKeys(ps.getProperty("State"));
		driver.findElement(By.name("postalCode")).sendKeys(ps.getProperty("PC"));
		WebElement cntry = driver.findElement(By.name("country"));
		Select s1 = new Select(cntry);
		s1.selectByIndex(100);
		driver.findElement(By.id("email")).sendKeys(ps.getProperty("UN"));
		driver.findElement(By.name("password")).sendKeys(ps.getProperty("Pass"));
		driver.findElement(By.name("confirmPassword")).sendKeys(ps.getProperty("CP"));
		driver.findElement(By.name("submit")).click();

	}

	@AfterMethod
	private void CaptureSS() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\user\\Documents\\Screenshots\\LoginSS"));
		System.out.println("ScreenShot Captured Successfully");
	}

	@AfterSuite
	private void closePage() {
		driver.close();

	}

}
