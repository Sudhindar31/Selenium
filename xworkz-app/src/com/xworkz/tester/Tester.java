package com.xworkz.tester;

import java.io.IOException;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;

import com.xworkz.Helper.Helper;
import com.xworkz.LaunchingBrowser.LaunchingBrowser;

public class Tester {

	public static void main(String[] args) {
		WebDriver driver = null;
		Helper help;
		try {
			help = LaunchingBrowser.gethelperobj();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the browser in which you want to execute");
			String b = scan.next();
			scan.close();
			driver = LaunchingBrowser.browserInitiation(b);
			driver.get(help.getproperty("URL"));
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}

}
