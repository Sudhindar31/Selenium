package com.xworkz.page.register;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	private WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	private static final String EMAIL_ID_KEY = "email";
	private static final String PASSWORD_ID_KEY = "psw";
	private static final String REPEATPASSWORD_ID_KEY = "psw-repeat";
	private static final String COURSES_ID_KEY = "courses";
	private static final String REGISTER_XPATH_KEY = "//button[contains(text(),'Register')]";

	public By identifyElementById(String idLocator) {
		return By.id(idLocator);
	}

	public By identifyElementByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	public void enterEmailId(String email) {
		driver.findElement(identifyElementById(EMAIL_ID_KEY)).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(identifyElementById(PASSWORD_ID_KEY)).sendKeys(password);
	}

	public void repeatPassword(String repeatpassword) {
		driver.findElement(identifyElementById(REPEATPASSWORD_ID_KEY)).sendKeys(repeatpassword);
	}

	public void selectaCourse(String coursename) {
		Select coursesdrpdown = new Select(driver.findElement(identifyElementById(COURSES_ID_KEY)));
		coursesdrpdown.selectByValue(coursename);
	}

	public void selectGenderRadioButton(String gender) {
		driver.findElement(identifyElementById(gender.toLowerCase())).click();
	}

	public void clickRegisterButton() {
		WebElement registerButton = driver.findElement(identifyElementByXpath(REGISTER_XPATH_KEY));
		scrollToElement(registerButton);
		registerButton.click();
	}

	public void scrollToElement(WebElement registerButton) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", registerButton);
	}
}
