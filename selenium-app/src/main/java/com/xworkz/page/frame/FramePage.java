package com.xworkz.page.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage {
	private WebDriver driver;

	public FramePage(WebDriver driver) {
		this.driver = driver;
	}

	private static final String BACKLINK_XPATH_KEY = "//a[contains(normalize-space(),'Back')]";

	public By identifyElementById(String idLocator) {
		return By.id(idLocator);
	}

	public By identifyElementByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	public void clickBackLink() {
		driver.findElement(identifyElementByXpath(BACKLINK_XPATH_KEY)).click();
	}

	public int switchFrames(int index) {
		driver.switchTo().frame(index);
		return index;
	}
}
