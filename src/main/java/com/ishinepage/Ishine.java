package com.ishinepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ishine {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);

		driver.get("https://ishine.apmosys.com/#/login");
		Thread.sleep(2000);

		String username = "biswajit.sahoo@apmosys.com";
		String password = "Welcome@2022";

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[text()='SIGN IN']")).click();
		Thread.sleep(2000);
		
		WebDriver driver1 = new ChromeDriver(option);
		
		driver1.get("https://mail.apmosys.com/webmail/#sign-in");
		Thread.sleep(3000);
		
		driver1.findElement(By.name("email-address")).sendKeys(username);
		driver1.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(2000);
		
		driver1.findElement(By.name("password")).sendKeys(password);
		driver1.findElement(By.xpath("//*[text()='Sign in']")).click();
		Thread.sleep(20000);
		
		driver1.switchTo().frame(driver1.findElement(By.xpath("//*[@id=\"gui.frm_main.main.mailview#frame\"]")));
		Thread.sleep(2000);
		
		String otp=driver1.findElement(By.xpath("//*[@id=\"iw_webmail_msg_body\"]/div/p")).getText();
		
		String OTP=otp.substring(21, 27);
		
		System.out.println(otp);
		System.out.println(otp.length());
		System.out.println(OTP);
		
		driver1.quit();
		
		Thread.sleep(5000);
		driver.findElement(By.id("userOtp")).sendKeys(OTP);
		
		driver.findElement(By.xpath("//*[text()='Confirm']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//*[@class='sidenav-nav-item'])[5]")).click();
		Thread.sleep(5000);
		
		Select s=new Select(driver.findElement(By.xpath("(//*[@class='form-control ng-untouched ng-pristine ng-valid'])[1]")));
		s.selectByVisibleText("Working");
		
		
		
		
		

	}

}
