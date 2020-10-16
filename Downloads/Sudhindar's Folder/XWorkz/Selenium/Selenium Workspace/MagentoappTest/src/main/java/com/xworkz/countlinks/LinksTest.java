package com.xworkz.countlinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksTest {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\kanchi\\Downloads\\Sudhindar's Folder\\XWorkz\\Selenium\\Selenium WebDriver\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.magento.com");
			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("The number of links found in the Magento application is :" + links.size());
			for (WebElement myacclink : links) {
				if (myacclink.getText() != "" && myacclink.getText().contains("My Account")) {
					myacclink.findElement(By.xpath("//a[text()='My Account']")).click();
					Thread.sleep(5000);
					System.out.println("My Account link is clicked");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}

}
