package br.com.alura.leilao;

import org.junit.function.ThrowingRunnable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	private static final String URL_LOGIN = "http://localhost:8080";
	private WebDriver driver;
	
	public LoginPage() {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.navigate().to(URL_LOGIN);
	}
	
	public void fechar() {
		// TODO Auto-generated method stub
		this.driver.quit();
	}

	public void preencheFormularioDeLoginComDadosInvalidos(String usuario, String senha) {
		// TODO Auto-generated method stub
		driver.findElement(By.className("form-control")).sendKeys(usuario);
		driver.findElement(By.name("password")).sendKeys(senha);
	}

	public void clicarBtnEntrar() {
		// TODO Auto-generated method stub
		driver.findElement(By.className("text-light")).click();
	}

	public void clicarBtnLogin() {
		// TODO Auto-generated method stub
		driver.findElement(By.className("btn-primary")).click();
	}

	public ThrowingRunnable retornElemento() {
		// TODO Auto-generated method stub
		return (ThrowingRunnable) driver.findElement(By.className("font-italic"));
	}

	public void paginaParaRealizarLeiloes() {
		// TODO Auto-generated method stub
		driver.navigate().to("http://localhost:8080/leiloes/2");
	}

	public boolean isUrl(String url) {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl().equals(url);
	}

	public boolean paginaContainsTexto(String texto) {
		// TODO Auto-generated method stub
		return driver.getPageSource().contains(texto);
	}


}
