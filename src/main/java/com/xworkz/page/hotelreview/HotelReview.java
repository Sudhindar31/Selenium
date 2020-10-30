package com.xworkz.page.hotelreview;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HotelReview {
	private WebDriver driver;
	JavascriptExecutor javaScriptExecutor;
	Actions actions;

	public HotelReview(WebDriver driver) {
		this.driver = driver;
	}

	private static final String SELECTTHEHOTEL_XPATH_KEY = "//div[@class='result-title']//span[contains(text(),'Club Mahindra Madikeri, Coorg')]";
	private static final String WRITEREVIEWBUTTON_XPATH_KEY = "//div[@id='component_14']//a[@class='ui_button primary']";
	private static final String HIGHLIGHTRATING_XPATH_KEY = "//span[@class='ui_bubble_rating fl bubble_50']";
	private static final String TITLEOFREVIEW_XPATH_KEY = "//input[@id='ReviewTitle']";
	private static final String REVIEWTEXT_XPATH_KEY = "//textarea[@id='ReviewText']";
	private static final String SUBMITYOURREVIEW_XPATH_KEY = "//input[@id='noFraud']";

	public By identifyElementById(String idLocator) {
		return By.id(idLocator);
	}

	public By identifyElementByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	public void scrollToElement(WebElement writeReviewButton) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", writeReviewButton);
	}

	public void selectTheHotel() {
		driver.findElement(identifyElementByXpath(SELECTTHEHOTEL_XPATH_KEY)).click();
	}

	public void clickWriteReviewButton() {
		WebElement writeReviewButton = driver.findElement(By.xpath(WRITEREVIEWBUTTON_XPATH_KEY));
		scrollToElement(writeReviewButton);
		writeReviewButton.click();
	}

	public void selectRating() {
		actions = new Actions(driver);
		WebElement highlightRating = driver.findElement(By.xpath(HIGHLIGHTRATING_XPATH_KEY));
		actions.moveToElement(highlightRating).build().perform();
		highlightRating.click();

	}

	public void switchWindow(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}

	public void reviewTitle(String reviewTitleText) {
		driver.findElement(identifyElementByXpath(TITLEOFREVIEW_XPATH_KEY)).sendKeys(reviewTitleText);
	}

	public void reviewText(String reviewText) {
		driver.findElement(identifyElementByXpath(REVIEWTEXT_XPATH_KEY)).sendKeys(reviewText);
	}

	public void checkboxSubmitYourReview() {
		WebElement submitReview = driver.findElement(identifyElementByXpath(SUBMITYOURREVIEW_XPATH_KEY));
		scrollToElement(submitReview);
		submitReview.click();
	}
}
