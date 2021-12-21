package br.com.alura.leilao;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginInvalido {
	
	private static final String URL_LOGIN = "http://localhost:8080";
	private WebDriver driver;

	@BeforeAll
	public static void beforeAll() {
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
	}
	@BeforeEach
	public void beforeEacht(){
		this.driver = new ChromeDriver();
		
		//url
		this.driver.navigate().to(URL_LOGIN);
	}
	@AfterEach
	public void afterEacg(){
		this.driver.quit();
	}
	
	@Test
	public void deveriaEfetuarLoginComDadosInvalidos() {
		
		// Clicando no botão "Entrar"
		driver.findElement(By.className("text-light")).click();
		
		// Usuário e senha
		driver.findElement(By.className("form-control")).sendKeys("kaio");
		driver.findElement(By.name("password")).sendKeys("1234");
		
		// Clicando no botão "Login"
		driver.findElement(By.className("btn-primary")).click();
		
		// Vasculha um texto especificado na página 
		Assert.assertTrue(driver.getPageSource().contains("Usuário e senha inválidos."));
		
		// Verificando se o nome do usuário não está aparecendo no NavBar da página.
		Assert.assertThrows(NoSuchElementException.class, () -> driver.findElement(By.className("font-italic")));
		
	}
}
