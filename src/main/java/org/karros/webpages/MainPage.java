package org.karros.webpages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MainPage {

	WebDriver driver;
	public static By txtEmail = By.name("email");
	public static By studentTable = By.xpath(".//tbody//tr");
	public static By studentNameTableRow = By.xpath(".//td[6]");
	public static By titleFirstName = By.xpath(".//th[@title ='First Name']");

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSort() {
		driver.findElement(titleFirstName).click();
	}

	public void getList() {
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(studentTable);
		// Get current list
		for (WebElement we : elementList) {
			obtainedList.add(we.findElement(studentNameTableRow).getText());
		}

		// Sorting the array
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);

		Assert.assertEquals(obtainedList, sortedList);
	}

	public void checkSortOrder() {
		this.clickSort(); //Sort ASC
		this.clickSort(); //Sort DESC
		this.getList();
	}

}
