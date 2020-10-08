package com.xworkz.amazonflipkartphonepricecompare;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.xworkz.helper.Helper;
import com.xworkz.launchingbrowser.LaunchingBrowser;

public class AFPhonePriceCompare {
	static WebDriver driver = null;
	static Helper help;

	public static String getamazonprice() {
		String aprice = null;
		try {
			help = LaunchingBrowser.gethelperobj();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the browser in which you want to execute");
			String b = scan.next();
			scan.close();
			driver = LaunchingBrowser.browserInitiation(b);
			driver.get(help.getproperty("URL1"));
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(help.getproperty("searchtext"));
			driver.findElement(By.xpath("//span[@id='nav-search-submit-text']//input[@class='nav-input']")).click();
			aprice = driver
					.findElement(By.xpath(
							"//a[contains(@href,'/Apple-iPhone-11-128GB-White/')]//span[@class='a-price-whole']"))
					.getText().replaceAll("[^a-zA-Z0-9]", "");
			System.out.println("The price of the " + help.getproperty("searchtext") + " in amazon is :" + aprice);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return aprice;
	}

	public static String getflipkartprice() {
		String fprice = null;
		try {
			driver.get(help.getproperty("URL2"));
			driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
			driver.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys(help.getproperty("searchtext"));
			driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
			Thread.sleep(5000);
			fprice = driver.findElement(By.xpath("//div[@class='_1vC4OE _2rQ-NK']")).getText()
					.replaceAll("[^a-zA-Z0-9]", "");

			System.out.println("The price of the " + help.getproperty("searchtext") + " in flipkart is: " + fprice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fprice;
	}

	public static void pricecompare() {
		try {
			String aprice = getamazonprice();
			String fprice = getflipkartprice();

			int ap = Integer.parseInt(aprice);
			int fp = Integer.parseInt(fprice);

			if (ap > fp) {
				System.out.println("The price of the " + help.getproperty("searchtext")
						+ " in Flipkart is less than the price in Amazon");
			} else if (fp > ap) {
				System.out.println("The price of the " + help.getproperty("searchtext")
						+ " in Amazon is less than the price in Flipkart");
			} else {
				System.out.println("The price of the " + help.getproperty("searchtext") + " in Amazon is : " + ap
						+ " is same as the price in Flipkart :" + fp);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.close();
			}
		}

	}

}