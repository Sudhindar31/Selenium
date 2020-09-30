package com.xworkz.launchingbrowser;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.xworkz.helper.Helper;

public class LaunchingBrowser {
	
	static WebDriver driver;

	public static Helper gethelperobj() throws IOException {
		Helper help = new Helper();
		return help;
	}

	public static WebDriver browserInitiation(String browser) throws IOException {
		Helper help = gethelperobj();
		System.setProperty("webdriver.chrome.driver", help.getproperty("chromedriverpath"));
		System.setProperty("webdriver.gecko.driver", help.getproperty("firefoxdriverpath"));
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else {
			System.out.println("Please enter either chrome or firefox");
		}
		return driver;
	}
}
