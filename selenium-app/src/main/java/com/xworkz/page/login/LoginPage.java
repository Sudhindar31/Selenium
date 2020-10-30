package com.xworkz.page.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private static final String EMAIL_XPATH_KEY = "//input[@placeholder='Enter valid email']";
	private static final String PASSWORD_XPATH_KEY = "//input[@placeholder='Enter Password']";
	private static final String REMEMBERME_XPATH_KEY = "//input[@name='remember']";
	private static final String LOGIN_XPATH_KEY = "//button[@type='submit']";

	public By identifyElementById(String idLocator) {
		return By.id(idLocator);
	}

	public By identifyElementByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	public void enterEmailId(String email) {
		driver.findElement(identifyElementByXpath(EMAIL_XPATH_KEY)).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(identifyElementByXpath(PASSWORD_XPATH_KEY)).sendKeys(password);
	}

	public void isRememberMeChecked() {
		if (driver.findElement(identifyElementByXpath(REMEMBERME_XPATH_KEY)).isSelected()) {
			driver.findElement(identifyElementByXpath(REMEMBERME_XPATH_KEY)).click();
		} else {
			System.out.println("The remember me checkbox is not checked");
		}
	}

	public void clickLoginButton() {
		driver.findElement(identifyElementByXpath(LOGIN_XPATH_KEY)).click();
	}
}
