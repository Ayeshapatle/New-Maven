package propertiesFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class propertiesFileDemo {
	static WebDriver driver;
	Properties pro = new Properties();

	@BeforeSuite
	public void openBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Requireds\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("E:\\Selenium Requireds\\Property Files\\MercuryT.properties");
		pro.load(fis);
		System.out.println("Chrome Browser Opne");
	}

	@BeforeTest
	public void passUrl() {
		driver.get("https://demo.guru99.com/test/newtours/index.php");
	}

	@BeforeClass
	private void max() {
		driver.manage().window().maximize();

	}

	@Test
	private void loginCheck() {
		driver.findElement(By.name("userName")).sendKeys(pro.getProperty("login"));
		driver.findElement(By.name("password")).sendKeys(pro.getProperty("pass"));
		driver.findElement(By.name("submit")).click();

	}

}
