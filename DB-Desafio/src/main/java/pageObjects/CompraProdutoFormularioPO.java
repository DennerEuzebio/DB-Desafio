package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CompraProdutoFormularioPO extends SeleniumAbstraction {

	public CompraProdutoFormularioPO(WebDriver driver) {
		super(driver);
	}
	
	protected String inicioUrl() {
		return "http://automationpractice.com/index.php";
	}

	protected WebElement getCampoGenero() {
		return byId("uniform-id_gender1");
	}

	protected WebElement getCampoNome() {
		return byId("customer_firstname");
	}

	protected WebElement getCampoSobrenome() {
		return byId("customer_lastname");
	}

	protected WebElement getCampoSenha() {
		return byId("passwd");
	}

	protected Select getCampoDiaNascimento() {
		return selectById("days");
	}

	protected Select getCampoMesNascimento() {
		return selectById("months");
	}

	protected Select getCampoAnoNascimento() {
		return selectById("years");
	}

	protected WebElement getCampoCompanhia() {
		return byId("company");
	}

	protected WebElement getCampoEndereco() {
		return byId("address1");
	}

	protected WebElement getCampoEndereco2() {
		return byId("address2");
	}

	protected WebElement getCampoCidade() {
		return byId("city");
	}

	protected Select getCampoEstado() {
		return selectById("id_state");
	}

	protected WebElement getCampoPostCode() {
		return byId("postcode");
	}

	protected WebElement getCampoPhone() {
		return byId("phone");
	}
	protected WebElement getCampoPhoneMobile() {
		return byId("phone_mobile");
	}
	
	protected WebElement getBotaoRegister() {
		return byId("submitAccount");
	}
	
	protected String getNomeTelaEnderecos() {
		return byXpath("/html/body/div/div[2]/div/div[3]/div/h1").getAttribute("innerText");
	}
	
	protected String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	protected String getUrlMinhaConta () {
		return inicioUrl()+"?controller=my-account";
	}
	
	protected String getEstadoSelecionado() {
		return selectById("id_state").getAllSelectedOptions().get(0).getAttribute("innerText");
	}
}
