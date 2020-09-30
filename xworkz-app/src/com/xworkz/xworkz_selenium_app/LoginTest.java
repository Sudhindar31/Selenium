package com.xworkz.xworkz_selenium_app;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.xworkz.Helper.Helper;
import com.xworkz.LaunchingBrowser.LaunchingBrowser;

public class LoginTest {

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
			// WebDriverWait wait = new WebDriverWait(driver,10);
			driver.get(help.getproperty("URL"));
			driver.findElement(By.linkText("Login")).click();
			driver.findElement(By.name("email")).sendKeys(help.getproperty("Email"));
			driver.findElement(By.name("psw")).sendKeys(help.getproperty("Password"));
			WebElement remembermeradiobtn = driver.findElement(By.name("remember"));
			Thread.sleep(2000);
			if (remembermeradiobtn.isSelected()) {
				remembermeradiobtn.click();
				Thread.sleep(2000);
			}
			driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
			String regsuccess = driver.findElement(By.xpath("//h1[contains(text(),'Login is successful')]"))
					.getText();
			if (regsuccess.equalsIgnoreCase("Login is successful")) {
				System.out.println("Login is Successful");
				driver.findElement(By.className("goback")).click();
				System.out.println(driver.getTitle());
				if (driver.getTitle().equalsIgnoreCase("register")) {
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
