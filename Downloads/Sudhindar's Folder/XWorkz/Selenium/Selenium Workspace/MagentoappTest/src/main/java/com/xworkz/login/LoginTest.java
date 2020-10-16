package com.xworkz.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\kanchi\\Downloads\\Sudhindar's Folder\\XWorkz\\Selenium\\Selenium WebDriver\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.magento.com");
			driver.findElement(By.xpath("//div[@class='account-icon icon-container']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
			driver.findElement(By.xpath("//div[@class='login-form__bottom']//button[@id='send2']")).click();
			System.out.println("Login into the Magento application is successful");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
			System.out.println("Logged out of the Magento application is successful");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}

}
