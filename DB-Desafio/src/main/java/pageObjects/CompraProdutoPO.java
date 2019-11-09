package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompraProdutoPO extends SeleniumAbstraction {

	protected CompraProdutoPO(WebDriver driver) {
		super(driver);
	}

	protected String inicioUrl() {
		return "http://automationpractice.com/index.php";
	}

	protected WebElement getProduto(int item) {
		return byXpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[" + item + "]/div/div[2]/h5/a");
	}

	protected WebElement getBotaoAddToCart() {
		return byId("add_to_cart");
	}

	protected float getPrecoProduto() {
		return Float.parseFloat(byId("our_price_display").getAttribute("innerText").substring(1));
	}

	protected String getProdutoNome() {
		return byId("product_reference").getAttribute("innerText").substring(6);
	}

	protected WebElement getBotaoCheckoutJanela() {
		return byXpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a");
	}

	protected String getNomeProdutoNoCarrinho() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/small[1]")
				.getAttribute("innerText");
	}

	protected boolean modalCartEstaPresente() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]")));
		return byXpath("//*[@id=\"layer_cart\"]").isDisplayed();
	}

	protected WebElement getBotaoCheckoutCarrinho() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]");
	}

	protected WebElement getCampoEmail() {
		return byId("email_create");
	}

	protected String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	protected String getUrlProduto(int item) {
		return inicioUrl() + "?id_product=" + item + "&controller=product";
	}

	protected String getUrlCarrinho() {
		return inicioUrl() + "?controller=order";
	}

	protected String getUrlTelaDeLogin() {
		return inicioUrl()
				+ "?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";
	}

	protected WebElement getBotaoCreateAcount() {
		return byId("SubmitCreate");
	}

	protected String getNomeTelaLogin() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/h1").getAttribute("innerText");
	}

	protected String getNomeTelaFormulario() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/h3").getAttribute("innerText");
	}

	protected String getUrlEndereco() {
		return inicioUrl() + "?controller=order&step=1&multi-shipping=0";
	}

	protected String getEndereco() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/form/div/div[2]/div[1]/ul/li[4]")
				.getAttribute("innerText");
	}

	protected String getEndereco2() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/form/div/div[2]/div[1]/ul/li[5]")
				.getAttribute("innerText");
	}

	protected WebElement getBotaoCheckoutEnderecos() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/form/p/button");
	}

	protected WebElement getCheckboxTermos() {
		return byId("cgv");
	}

	protected String getNomePaginaEntrega() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/div/h1").getAttribute("innerText");
	}
	
	protected float getPrecoEntrega() {
		return Float.parseFloat(byXpath("/html/body/div/div[2]/div/div[3]/div/div/form/div/div[2]/div[1]/div/div/table/tbody/tr/td[4]/div").getAttribute("innerText").substring(1));
	}

	protected WebElement getBotaoCheckoutEntrega() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button");
	}
	
	protected float getPrecoFinal() {
		return Float.parseFloat(byId("total_price_container").getAttribute("innerText").substring(1));
	}
	
	protected String getNomePaginaPagamento() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/h1").getAttribute("innerText");
	}
	
	protected WebElement getBotaoPagamentoTransferencia() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p");
	}
	
	protected String getNomePaginaConfirmaPagamento() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/h1").getAttribute("innerText");
	}
	
	
	protected WebElement getBotaoCheckoutConfirmaPagamento() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/form/p/button");
	}
	
	protected String getConfirmacaoDeCompra() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/div/p/strong").getAttribute("innerText");
	}
	
}
