package com.xworkz.page.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private static final String REGISTERBUTTON_XPATH_KEY = "//a[@class='active']";
	private static final String LOGINBUTTON_XPATH_KEY = "//a[contains(text(),'Login')]";

	public By identifyElementById(String idLocator) {
		return By.id(idLocator);
	}

	public By identifyElementByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	public void registerLinkClick() {
		driver.findElement(identifyElementByXpath(REGISTERBUTTON_XPATH_KEY)).click();
	}

	public void loginLinkClick() {
		driver.findElement(identifyElementByXpath(LOGINBUTTON_XPATH_KEY)).click();
	}

	public boolean isregisterLinkEnabled() {
		if (driver.findElement(identifyElementByXpath(REGISTERBUTTON_XPATH_KEY)).isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isLoginLinkEnabled() {
		if (driver.findElement(identifyElementByXpath(LOGINBUTTON_XPATH_KEY)).isEnabled()) {
			return true;
		} else {
			return false;
		}
	}
}
