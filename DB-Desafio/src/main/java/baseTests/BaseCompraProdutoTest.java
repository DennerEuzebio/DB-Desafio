package baseTests;

import java.text.DateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseCompraProdutoTest {

	protected WebDriver driver;
	
	public BaseCompraProdutoTest(WebDriver driver) {
		this.driver = driver;
	}
	public BaseCompraProdutoTest() {
		
	}

	protected static ExtentTest test;
	static ExtentReports report;
	
	@Before
	public void setupTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void teardown() {
		if (driver != null)
			driver.quit();
	}

	@BeforeClass
	static public void setupClass() {
		java.util.Date d = new Date();
		String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
		System.setProperty("webdriver.chrome.driver", "Chromedriver/chromedriver.exe");
		report = new ExtentReports(System.getProperty("user.dir") + "\\TesteFormulario "+dStr+".html");
		test = report.startTest("TesteFormulario");
	}
	
	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}
		

}
