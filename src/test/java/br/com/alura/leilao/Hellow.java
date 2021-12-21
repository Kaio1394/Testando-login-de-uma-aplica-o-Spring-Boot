package br.com.alura.leilao;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hellow {
	
	@Before
	public void start(){
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
	}
	
	@Test
	public void hellow() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8080");
		driver.findElement(By.className("text-light")).click();
		driver.findElement(By.className("form-control")).sendKeys("kaio13");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.quit();
	}
}