package com.xworkz.page.landing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	private WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private static final String FRAMEBUTTON_XPATH_KEY = "//button[@type='submit']";
	private static final String ALERTBUTTON_XPATH_KEY = "//button[contains(normalize-space(),'Alert')]";
	private static final String PROMPTBUTTON_XPATH_KEY = "//button[contains(normalize-space(),'Prompt')]";
	private static final String CONFIRMBUTTON_XPATH_KEY = "//button[contains(normalize-space(),'Confirm')]";
	private static final String NEWTABLINK_XPATH_KEY = "//a[@href='NewTab.jsp']";
	private static final String GOBACKLINK_XPATH_KEY = "//a[@class='goback']";

	public By identifyElementById(String idLocator) {
		return By.id(idLocator);
	}

	public By identifyElementByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	public void clickFrameButton() {
		driver.findElement(identifyElementByXpath(FRAMEBUTTON_XPATH_KEY)).click();
	}

	public void clickAlertButton() {
		driver.findElement(identifyElementByXpath(ALERTBUTTON_XPATH_KEY)).click();
		driver.switchTo().alert().accept();
	}
	public void clickPromptButton(String age) throws InterruptedException {
		driver.findElement(identifyElementByXpath(PROMPTBUTTON_XPATH_KEY)).click();
		Thread.sleep(4000);
		if (age != null || age != "") {
			Thread.sleep(4000);
			driver.switchTo().alert().sendKeys(age);
			System.out.println("Clicked OK");
		} 
			Thread.sleep(4000);
			driver.switchTo().alert().dismiss();
			System.out.println("Clicked Cancel");
	}

	public void clickConfirmButton(String accept) {
		driver.findElement(identifyElementByXpath(CONFIRMBUTTON_XPATH_KEY)).click();
		if (accept.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
		}
	}

	public void clickNewTabLink() {
		driver.findElement(identifyElementByXpath(NEWTABLINK_XPATH_KEY)).click();
	}

	public void clickGoBackLink() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(identifyElementByXpath(GOBACKLINK_XPATH_KEY)).click();
	}
}
