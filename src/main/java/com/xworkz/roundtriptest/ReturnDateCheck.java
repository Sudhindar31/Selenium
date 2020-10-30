package com.xworkz.roundtriptest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReturnDateCheck {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\kanchi\\Downloads\\Sudhindar's Folder\\XWorkz\\Selenium\\Selenium WebDriver\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://www.cleartrip.com");
			WebElement roundtripradiobtn = driver.findElement(By.xpath("//input[@id='RoundTrip']"));
			if (roundtripradiobtn.isSelected()) {
				WebElement returndateselect = driver.findElement(By.xpath("//input[@id='ReturnDate']"));
				if (returndateselect.isDisplayed()) {
					returndateselect.click();
				} else {
					System.out.println("The Return date field is not displayed");
				}
			} else {
				roundtripradiobtn.click();
			}
			WebElement selectReturnDate = driver
					.findElement(By.xpath("//dl[@id='ReturnDateContainer']//i[@class='icon ir datePicker']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", selectReturnDate);
			selectReturnDate.click();
			driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//a[contains(text(),'17')][1]")).click();
			System.out.println("The Return date field is updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
