package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAbstraction {
	
	public  WebDriver driver;
	protected WebDriverWait wait;

	public SeleniumAbstraction(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
	}
	
	protected WebElement byXpath(String xpath) {
		wait(By.xpath(xpath));
		return driver.findElement(By.xpath(xpath));
		
	}
	protected WebElement byCss(String css) {
		wait(By.cssSelector(css));
		return driver.findElement(By.cssSelector(css));
		
	}
	protected WebElement byId(String id) {
		wait(By.id(id));
		return driver.findElement(By.id(id));
	}
	
	private void wait(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	protected Select selectById(String id) {
		wait(By.id(id));
		return new Select(driver.findElement(By.id(id)));
	}
	
	protected Select selectByCss(String css) {
		wait(By.cssSelector(css));
		return new Select(driver.findElement(By.cssSelector(css)));
	}
	
	protected Select selectByXpath(String xpath) {
		wait(By.xpath(xpath));
		return new Select(driver.findElement(By.xpath(xpath)));
	}
}

