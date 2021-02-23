package com.Scripts;

import java.util.Date;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicCalender {
	WebDriver driver;
	@Test
	public void ts() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions act= new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		Date date=new Date();
		String strDate=date.toString();
		String[] strArr=strDate.split(" ");
		String day=strArr[0];
		String month=strArr[1];
		String adate=strArr[2];
		String year= strArr[5];
		driver.findElement(By.xpath("//div[@aria-label='"+day+" "+month+" "+adate+" "+year+"']/div/p[text()='"+adate+"']")).click();
	}
}
