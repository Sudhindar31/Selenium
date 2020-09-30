package com.xworkz.xworkz_selenium_app;

import java.io.IOException;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.xworkz.helper.Helper;
import com.xworkz.launchingbrowser.LaunchingBrowser;

public class RegisterTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		Helper help;
		try {
			help = LaunchingBrowser.gethelperobj();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the browser in which you want to execute");
			String b = scan.next();
			scan.close();
			driver = LaunchingBrowser.browserInitiation(b);
			//WebDriverWait wait = new WebDriverWait(driver,10);
			driver.get(help.getproperty("URL"));
			driver.findElement(By.className("active")).click();
			driver.findElement(By.id("email")).sendKeys(help.getproperty("Email"));
			driver.findElement(By.id("psw")).sendKeys(help.getproperty("Password"));
			driver.findElement(By.id("psw-repeat")).sendKeys(help.getproperty("Password"));
			Select coursesdrpdown = new Select(driver.findElement(By.id("courses")));
			coursesdrpdown.selectByValue(help.getproperty("Course"));
			WebElement radio = driver.findElement(By.id("male"));//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='male']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);
			//radio.click();
			driver.findElement(By.className("registerbtn")).click();
			String regsuccess = driver.findElement(By.xpath("//h1[contains(text(),'Registration is successful')]"))
					.getText();
			if (regsuccess.equalsIgnoreCase("registration is successful")) {
				System.out.println("Registration is successfully completed");
				driver.findElement(By.className("goback")).click();
				Thread.sleep(500);
				System.out.println(driver.getTitle());
				if(driver.getTitle().equalsIgnoreCase("register")) {
					System.out.println("closing the browser");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}
