package br.com.alura.leilao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	@Before
	public void start(){
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
	}
	@After
	public void finalizar(){}
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8080");
		driver.findElement(By.className("text-light")).click();
		driver.findElement(By.className("form-control")).sendKeys("fulano");
		driver.findElement(By.name("password")).sendKeys("pass");
		driver.findElement(By.className("btn-primary")).click();
		
		
		Assert.assertFalse(driver.getCurrentUrl().equals("http://localhost:8080/login"));
		String fulano = driver.findElement(By.className("font-italic")).getText();
		Assert.assertEquals("fulano", fulano);
		driver.quit();
		
	}
}
