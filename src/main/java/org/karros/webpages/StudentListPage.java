package org.karros.webpages;

import java.util.ArrayList;
import java.util.List;
import org.karros.locators.StudentList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StudentListPage {

	WebDriver driver;

	public void getList() {

		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(StudentList.tblRow);
		for (WebElement we : elementList) {
			we.findElement(By.xpath("/td[6]"));
		}
	}

}
