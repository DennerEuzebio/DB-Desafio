package tasks;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import pageObjects.CompraProdutoFormularioPO;

public class CompraProdutoFormularioTasks extends CompraProdutoFormularioPO{

	public CompraProdutoFormularioTasks(WebDriver driver) {
		super(driver);
	}
	
	public void selecionaGenero() {
		getCampoGenero().click();
	}
	
	public void digitaNome(String nome) {
		getCampoNome().sendKeys(nome);
	}
	
	public void digitaSobrenome(String sobrenome) {
		getCampoSobrenome().sendKeys(sobrenome);
	}
	
	public void digitaSenha(String senha) {
		getCampoSenha().sendKeys(senha);
	}
	
	public void selecionaDiaNascimento(int index) {
		getCampoDiaNascimento().selectByIndex(index);
	}
	
	public void selecionaMesNascimento(int index) {
		getCampoMesNascimento().selectByIndex(index);
	}
	
	public void selecionaAnoNascimento(int index) {
		getCampoAnoNascimento().selectByIndex(index);
	}
	
	public void digitaCompanhia (String companhia) {
		getCampoCompanhia().sendKeys(companhia);
	}
	
	public void digitaEndereco (String endereco) {
		getCampoEndereco().sendKeys(endereco);
	}
	
	public void digitaEndereco2 (String endereco2) {
		getCampoEndereco2().sendKeys(endereco2);
	}
	
	public void digitaCidade (String cidade) {
		getCampoCidade().sendKeys(cidade);
	}

	
	public void selecionaEstadoPorIndex(int index) {
		getCampoEstado().selectByIndex(index);
	}
	
	public void digitaPostCode(String code) {
		getCampoPostCode().sendKeys(code);;
	}
	
	public void digitaPhone(String phone) {
		getCampoPhone().sendKeys(phone);
	}
	
	public void digitaPhoneMobile(String mobile) {
		getCampoPhoneMobile().sendKeys(mobile);
	}
	
	public void clicaBotaoRegister() {
		getBotaoRegister().click();
	}
	
	public void validaUrlMinhaConta() {	
		assertEquals(getUrlMinhaConta(), getCurrentUrl());
	}
	
	public String salvaEstadoSelecionado() {
		return getEstadoSelecionado();
	}
	
	
}

