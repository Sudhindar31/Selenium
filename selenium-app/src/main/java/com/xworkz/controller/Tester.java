package com.xworkz.controller;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.xworkz.page.frame.FramePage;
import com.xworkz.page.home.HomePage;
import com.xworkz.page.landing.LandingPage;
import com.xworkz.page.login.LoginPage;
import com.xworkz.page.newtab.NewTabPage;
//import com.xworkz.page.register.RegisterPage;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kanchi\\Downloads\\Sudhindar's Folder\\XWorkz\\Selenium\\Selenium WebDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/selenium-app");

		HomePage homePage = new HomePage(driver);
		// homePage.isregisterLinkEnabled();
		// homePage.registerLinkClick();
		homePage.isLoginLinkEnabled();
		homePage.loginLinkClick();

		/*
		 * RegisterPage registerPage = new RegisterPage(driver);
		 * registerPage.enterEmailId("test1@test.com");
		 * registerPage.enterPassword("Testpassword@01");
		 * registerPage.repeatPassword("Testpassword@01");
		 * registerPage.selectaCourse("selenium");
		 * registerPage.selectGenderRadioButton("male");
		 * registerPage.clickRegisterButton();
		 */

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailId("test1@test.com");
		loginPage.enterPassword("Testpassword@01");
		loginPage.isRememberMeChecked();
		loginPage.clickLoginButton();

		LandingPage landingPage = new LandingPage(driver);
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println(parentWindowHandle);
		landingPage.clickNewTabLink();
		/*
		 * Thread.sleep(4000); landingPage.clickFrameButton();
		 * 
		 * FramePage framePage = new FramePage(driver); Thread.sleep(4000);
		 * framePage.switchFrames(0); Thread.sleep(4000);
		 * homePage.isregisterLinkEnabled(); homePage.registerLinkClick();
		 */
		
		String childWindowHandle = "";
		
		NewTabPage newTabPage = new NewTabPage(driver);
		
		Set<String> allwindowHandles = driver.getWindowHandles();
		for (String windowHandle : allwindowHandles) {
			if (!windowHandle.equals(parentWindowHandle)) {
				childWindowHandle = windowHandle;
				newTabPage.switchWindow(childWindowHandle);
			}
		}
		newTabPage.clickWelcomeTab();
	}

}
