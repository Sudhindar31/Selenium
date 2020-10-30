package com.xworkz.controller;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.xworkz.page.home.HomePage;
import com.xworkz.page.hotelreview.HotelReview;

public class Tester {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kanchi\\Downloads\\Sudhindar's Folder\\XWorkz\\Selenium\\Selenium WebDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.tripadvisor.in/");

		HomePage homePage = new HomePage(driver);
		homePage.enterSearchCriteria("Club Mahindra");

		HotelReview hotelReview = new HotelReview(driver);
		String parentWindowHandle = driver.getWindowHandle();

		String childWindowHandle = "";

		hotelReview.selectTheHotel();

		Set<String> allwindowHandles = driver.getWindowHandles();
		for (String windowHandle : allwindowHandles) {
			if (!windowHandle.equals(parentWindowHandle)) {
				childWindowHandle = windowHandle;
				hotelReview.switchWindow(childWindowHandle);
			}
		}

		hotelReview.clickWriteReviewButton();
		
		String childWindowHandle2 = "";
		
		Set<String> allwindowHandles2 = driver.getWindowHandles();
		for (String windowHandle : allwindowHandles2) {
			if (!windowHandle.equals(parentWindowHandle)&&!windowHandle.equals(childWindowHandle)) {
				childWindowHandle2 = windowHandle;
				hotelReview.switchWindow(childWindowHandle2);
			}
		}
		//hotelReview.selectRating();
		
		hotelReview.reviewTitle("Test Review");
		hotelReview.reviewText("Test Review ...........................................................................................................................................................");
		hotelReview.checkboxSubmitYourReview();
	}

}
