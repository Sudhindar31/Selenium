package com.xworkz.amazonapptest;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.xworkz.helper.Helper;
import com.xworkz.launchingbrowser.LaunchingBrowser;

public class LoginTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = null;
		Helper help;
		help = LaunchingBrowser.gethelperobj();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the browser in which you want to execute");
		String b = scan.next();
		scan.close();
		driver = LaunchingBrowser.browserInitiation(b);
		driver.get(help.getproperty("URL"));
		WebElement menu = driver
				.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menu);
		WebElement signinbtn = driver.findElement(By.xpath(
				"//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-accountList']/div[2]/div[1]/div[1]/div[1]/a[1]/span[1]"));
		actions.moveToElement(signinbtn).click().build().perform();
		driver.findElement(By.id("ap_email")).sendKeys(help.getproperty("Email"));
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(help.getproperty("Password"));
		driver.findElement(By.id("signInSubmit")).click();
		String loginsuccess = driver.getTitle();
		if (loginsuccess.toLowerCase().contains("online shopping site in india")) {
			System.out.println("Login is successful, Home page is displayed");
		}
		Thread.sleep(3000);
		WebElement accdrpdwn = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		actions.moveToElement(accdrpdwn);
		WebElement signoutbtn = driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]"));
		actions.moveToElement(signoutbtn).click().build().perform();
		String logoutsuccess = driver.getTitle();
		if (logoutsuccess.equalsIgnoreCase("amazon sign in")) {
			System.out.println("Logout is successful");
		}
		Thread.sleep(3000);
		driver.close();
	}
}
