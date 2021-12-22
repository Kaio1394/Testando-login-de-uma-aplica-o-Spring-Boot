package br.com.alura.leilao;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoSuchElementException;

public class TestLoginInvalido {
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void beforeEach(){
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void fechar(){
		this.paginaDeLogin.fechar();
	}


	@Test
	public void deveriaEfetuarLoginComDadosInvalidos() {
		
		paginaDeLogin.clicarBtnEntrar();
		paginaDeLogin.preencheFormularioDeLoginComDadosInvalidos("kaio", "1234" );
		
		paginaDeLogin.clicarBtnLogin();
	
		Assert.assertTrue(paginaDeLogin.paginaContainsTexto("Usuário e senha inválidos."));
		Assert.assertThrows(NoSuchElementException.class, () -> paginaDeLogin.retornElemento());
		
	}
	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		paginaDeLogin.paginaParaRealizarLeiloes();
		Assert.assertTrue(paginaDeLogin.isUrl("http://localhost:8080/login"));
		Assert.assertFalse(paginaDeLogin.paginaContainsTexto("Dados do Leilão"));
	}
}
