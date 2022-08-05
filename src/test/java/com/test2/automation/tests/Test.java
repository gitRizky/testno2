package com.test2.automation.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	WebDriver driver;

	@org.junit.Test
	public void productCount() {
		WebDriverManager.chromedriver().browserVersion("104.0.5112.20").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tokopedia.com/");
		WebElement textBoxSearch = driver.findElement(By.cssSelector(
				"body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"));
		textBoxSearch.sendKeys("TV");
		WebElement iconSearch = driver.findElement(By.cssSelector("button[aria-label='Kirimkan']"));
		iconSearch.click();
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
		}
		List<WebElement> listElements = driver
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div"));
		int count = listElements.size();
		System.out.println("jumlah produk yang ditampilkan: " + count*10);
		driver.close();
	}
}
