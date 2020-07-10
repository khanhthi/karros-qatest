package org.karros.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	public static By txtEmail = By.xpath(".//input[@name='email']");
	public static By txtPassword = By.xpath(".//input[@name='password']");
	public static By btnLogin = By.xpath(".//a[text()='LOG IN']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
	
	public void setEmail (String strEmail) {
		driver.findElement(txtEmail).sendKeys(strEmail);
	}
	
	public void setPassword (String strPassword) {
		driver.findElement(txtPassword).sendKeys(strPassword);
	}
	
	public void clickLogin () {
		driver.findElement(btnLogin).click();
	}
	
    public void login(String strEmail, String strPasword){
        this.setEmail(strEmail);
        this.setPassword(strPasword);
        this.clickLogin();
    }

}
