package com.xworkz.amazonapptest;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.xworkz.helper.Helper;
import com.xworkz.launchingbrowser.LaunchingBrowser;

public class AddItemToCart {

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
		Thread.sleep(3000);
		Select categoriesdrpdwn = new Select(driver.findElement(By.id("searchDropdownBox")));
		categoriesdrpdwn.selectByVisibleText("Electronics");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 11 pro max 512gb");
		driver.findElement(By.xpath(
				"//header/div[@id='navbar']/div[@id='nav-belt']/div[2]/div[1]/form[1]/div[3]/div[1]/span[1]/input[1]"))
				.click();
		WebElement searchres = driver.findElement(By.xpath(
				"//body/div[@id='a-page']/div[@id='search']/div[1]/div[2]/div[1]/span[3]/div[2]/div[6]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/a[1]/div[1]/img[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchres);
		searchres.click();
		driver.findElement(By.id("add-to-cart-button")).click();
		
	}

}
