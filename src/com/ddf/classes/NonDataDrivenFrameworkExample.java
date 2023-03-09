package com.ddf.classes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NonDataDrivenFrameworkExample {

	public static void main(String[] args) {
		try {
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.webmath.com");
			WebElement generalMathLink = driver.findElement(By.linkText("General Math"));
			Thread.sleep(3000);
			generalMathLink.click();
			WebElement topicDropdown = driver.findElement(By.id("topicItem"));
			Select selectFromTopicDropdown = new Select(topicDropdown);
			selectFromTopicDropdown.selectByVisibleText("Interest, Simple");
			Thread.sleep(3000);
			WebElement principal = driver.findElement(By.name("principal"));
			principal.sendKeys("10000");
			
			Thread.sleep(3000);
			
			WebElement interest = driver.findElement(By.name("interest"));
			interest.sendKeys("7.4");
			Thread.sleep(3000);
			
			WebElement desiredTime = driver.findElement(By.name("desired_time"));
			desiredTime.sendKeys("5");
			Thread.sleep(3000);
			
			WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Find the amount of interest']"));
			submitBtn.click();
			Thread.sleep(3000);
			driver.quit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
