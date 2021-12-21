package br.com.alura.leilao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginInvalido {
	
	@Before
	public void start(){
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
	}
	@After
	public void finalizar(){}
	
	@Test
	public void deveriaEfetuarLoginComDadosInvalidos() {
		WebDriver driver = new ChromeDriver();
		//url
		driver.navigate().to("http://localhost:8080");
		
		// Clicando no botão "Entrar"
		driver.findElement(By.className("text-light")).click();
		
		// Usuário e senha
		driver.findElement(By.className("form-control")).sendKeys("kaio");
		driver.findElement(By.name("password")).sendKeys("1234");
		
		// Clicando no botão "Login"
		driver.findElement(By.className("btn-primary")).click();
		
		//Pega um texto da página
		Assert.assertTrue(driver.getPageSource().contains("Usuário e senha inválidos."));
		
		//Fecha a janela
		driver.quit();
		
	}
}
