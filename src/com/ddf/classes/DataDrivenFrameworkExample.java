package com.ddf.classes;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataDrivenFrameworkExample {
	public static void main(String[] args) {
		try {
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			FileInputStream fis = new FileInputStream("D:\\ExcelR\\Selenium_Morning\\DataDrivenFramework\\src\\com\\ddf\\utils\\inputs.properties");
			Properties p = new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			String principal_amount = p.getProperty("principal_amount");
			String rate_of_interest = p.getProperty("rate_of_interest");
			String desired_time = p.getProperty("desired_time");
			
			driver.get(url);
			WebElement generalMathLink = driver.findElement(By.linkText("General Math"));
			Thread.sleep(3000);
			generalMathLink.click();
			WebElement topicDropdown = driver.findElement(By.id("topicItem"));
			Select selectFromTopicDropdown = new Select(topicDropdown);
			selectFromTopicDropdown.selectByVisibleText("Interest, Simple");
			Thread.sleep(3000);
			WebElement principal = driver.findElement(By.name("principal"));
			principal.sendKeys(principal_amount);
			
			Thread.sleep(3000);
			
			WebElement interest = driver.findElement(By.name("interest"));
			interest.sendKeys(rate_of_interest);
			Thread.sleep(3000);
			
			WebElement desiredTime = driver.findElement(By.name("desired_time"));
			desiredTime.sendKeys(desired_time);
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
