package com.xworkz.page.newtab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTabPage {
	private WebDriver driver;

	public NewTabPage(WebDriver driver) {
		this.driver = driver;
	}

	private static final String WELCOMETAB_XPATH_KEY = "//a[@class='active']";

	public By identifyElementById(String idLocator) {
		return By.id(idLocator);
	}

	public By identifyElementByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	public void clickWelcomeTab() {
		driver.findElement(identifyElementByXpath(WELCOMETAB_XPATH_KEY)).click();
	}

	public void switchWindow(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}
}
