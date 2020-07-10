package org.karros.webpages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class StudentListPage {

	WebDriver driver;
	public static By txtEmail = By.name("email");
	public static By locateTable = By.xpath(".//tbody//tr");
	public static By locateRow = By.xpath(".//td[6]");
	public static By titleFirstName = By.xpath(".//th[@title ='First Name']");

	public StudentListPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSort() {
		driver.findElement(titleFirstName).click();
	}

	public void getList() {
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(locateTable);
		// Get current list
		for (WebElement we : elementList) {
			obtainedList.add(we.findElement(locateRow).getText());
		}

		// Sorting the array
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		
		System.out.print("Data sorted in list: " + obtainedList);
		System.out.print("Expectation data sort: " + sortedList);

		Assert.assertTrue(sortedList.equals(obtainedList));
	}

	public void checkSortOrder() {
		this.clickSort(); //Sort ASC
		this.clickSort(); //Sort DESC
		this.getList();
	}

}
