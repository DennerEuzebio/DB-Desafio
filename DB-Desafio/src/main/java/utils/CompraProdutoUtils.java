package utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CompraProdutoUtils {

	private WebDriver driver;
	private ExtentTest test;
	TakesScreenshot screen;

	public CompraProdutoUtils(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void geraRelatorioFormulario(String nome) {
		if (driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) {
			test.log(LogStatus.PASS, "O formulario foi preenchido corretamente");
		} else {
			test.log(LogStatus.FAIL, "O formulario foi não foi preenchido corretamente para o nome "+nome);
			print("Formulario preenchido errado de "+nome);
		}
	}

	public void print(String mensagem) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("Screenshots/"+mensagem+".jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String geraStringlAleatoria() {
		int leftLimit = 97; // letra 'a'
		int rightLimit = 122; // letra 'z'
		int targetStringLength = 6;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		return generatedString;
	}

	public int geraInteiroAleatorio(int limite) {
		Random random = new Random();
		return random.nextInt(limite) + 1;
	}

	public String geraStringNumerica() {
		String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String senha = "";
		for (int x = 0; x < 5; x++) {
			int j = (int) (Math.random() * carct.length);
			senha += carct[j];

		}
		return senha;
	}
}
