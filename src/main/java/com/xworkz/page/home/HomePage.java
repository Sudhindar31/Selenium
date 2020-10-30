package com.xworkz.page.home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private static final String SEARCHOPTION_XPATH_KEY = "//input[@placeholder='Where to?']";

	public By identifyElementById(String idLocator) {
		return By.id(idLocator);
	}

	public By identifyElementByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	public void enterSearchCriteria(String searchText) {
		WebElement searchBar = driver.findElement(By.xpath(SEARCHOPTION_XPATH_KEY));
		searchBar.sendKeys(searchText);
		searchBar.sendKeys(Keys.ENTER);
	}

}
