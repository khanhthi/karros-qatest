package org.karros;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.karros.webpages.LoginPage;
import org.karros.webpages.MainPage;

public class FirstNameSortTest {

	LoginPage objLogin;
	MainPage objStudent;
	WebDriver driver;
	//String chromeVersion = "83.0.4103.116";
	String siteURL = "http://ktvn-test.s3-website.us-east-1.amazonaws.com/";
	String strEmail = "admin@test.com";
	String strPasword = "test123";
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); 
		driver = new ChromeDriver(options); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(siteURL);
	}

	@BeforeClass
	public void loginToWeb() {	
		objLogin = new LoginPage(driver);
		objLogin.login(strEmail, strPasword);
		System.out.print("Login successful.");
	}
	
	@Test
	public void verifySortOrderFirstName() {	
		objStudent = new MainPage(driver);
		objStudent.checkSortOrder();
		System.out.print("First Name column is sorted correctly");
	}

	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}