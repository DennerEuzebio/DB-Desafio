package tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;

import pageObjects.CompraProdutoPO;

public class CompraProdutoTasks extends CompraProdutoPO {

	public CompraProdutoTasks(WebDriver driver) {
		super(driver);
	}

	public void clicaProduto(int item) {
		getProduto(item).click();
	}

	public void clicaAddToCart() {
		getBotaoAddToCart().click();
	}

	public float salvaPrecoDoProduto() {
		return getPrecoProduto();
	}

	public String salvaNomeProduto() {
		return getProdutoNome();
	}

	public void clicaBotaoCheckouJanela() {
		getBotaoCheckoutJanela().click();
	}

	public String nomeProdutoNoCarrinho() {
		return getNomeProdutoNoCarrinho();
	}

	public void clicaBotaoCheckoutCarrinho() {
		getBotaoCheckoutCarrinho().click();
	}

	public void validaCart() {
		assertTrue("A janela modal não está presente", modalCartEstaPresente());
	}

	public void acessarSite() {
		driver.get("http://automationpractice.com");
	}

	public void validaTelaProduto(int item) {
		assertEquals("Não está na URL correta", getUrlProduto(item), getCurrentUrl());
	}

	public void validaTelaCarrinho() {
		assertEquals(getUrlCarrinho(), getCurrentUrl());
	}

	public void validaNomeDoProdutoNoCarrinho(String actual, String expected) {
		assertTrue("Nome do item no carrinho diferente", actual.contains(expected));
	}

	public void digitaEmail(String email) {
		getCampoEmail().sendKeys(email);
	}

	public void clicaBotaoCreateAcount() {
		getBotaoCreateAcount().click();
	}

	public void validaTelaDeLogin() {
		assertTrue(getNomeTelaLogin(), getNomeTelaLogin().contains("AUTHENTICATION"));
	}

	public void validaTelaDoFormulario() {
		assertTrue(getNomeTelaFormulario(), getNomeTelaFormulario().contains("YOUR PERSONAL INFORMATION"));
	}

	public void validaTelaEnderecos() {
		assertEquals(getUrlEndereco(), getCurrentUrl());
	}
	
	public void validaEndereco(String endereco, String endereco2) {
		String enderecoFinal = endereco+" "+endereco2;
		assertEquals(enderecoFinal, getEndereco());
	}
	
	public void validaEndereco2(String cidade, String estado, String postalCode) {
		String enderecoFinal = cidade+", "+estado+" "+postalCode;
		assertEquals(enderecoFinal, getEndereco2());
	}
	
	public void clicaBotaoCheckoutEnderecos() {
		getBotaoCheckoutEnderecos().click();
	}
	
	public void clicaCheckboxTermo() {
		getCheckboxTermos().click();
	}
	
	public float salvaPrecoEntrega() {
		return getPrecoEntrega();
	}
	
	public void validaTelaEntrega() {
		assertTrue(getNomePaginaEntrega(),getNomePaginaEntrega().contains("SHIPPING"));
	}

	public void clicaBotaoCheckoutEntrega() {
		getBotaoCheckoutEntrega().click();
	}
	
	public void validaPrecoFinal(float precoProduto, float precoEntrega) {
		var precoFinal = precoProduto+precoEntrega;
		assertEquals(getPrecoFinal(), precoFinal,0.0f);
	}
	
	public void validaTelaPagamento() {
		assertTrue(getNomePaginaPagamento().contains("PLEASE CHOOSE YOUR PAYMENT METHOD"));
	}
	
	public void clicaBotaoPagamentoTransferecia(){
		getBotaoPagamentoTransferencia().click();
	}
	
	public void validaTelaConfirmaPagamento() {
		assertTrue(getNomePaginaConfirmaPagamento().contains("ORDER SUMMARY"));
	}
	
	public void clicaBotaoCheckoutConfirmaPagamento() {
		getBotaoCheckoutConfirmaPagamento().click();
	}
	
	public void validaConfirmacaoDeCompra() {
		assertTrue(getConfirmacaoDeCompra().contains("Your order on My Store is complete."));
	}
}
