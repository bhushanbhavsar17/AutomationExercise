package Object;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class eBayHomePage {
	WebDriver driver;

	public eBayHomePage(WebDriver driver) {

		this.driver = driver;
	}
	
	
	By search = By.id("gh-ac");
	By search_btn = By.id("gh-btn");
	By size = By.xpath("//div[contains(text(),'50') and contains(text(),'60')]");
	By product = By.xpath("//ul[@id='ListViewInner']//li[1]/h3/a");
	By addcart = By.id("isCartBtn_btn");
	By checkout = By.id("ptcBtnRight");
	By guest_btn = By.id("gtChk");
	By productdetails = By.id("itemTitle");
	By verifyprice = By.id("prcIsum");
	By item = By.id("vi-itm-cond");
	By titleName=By.xpath("//div[@id='ShopCart']//span[contains(@id,'title')]/a");
	By priceValue=By.className("fw-b");
	By totalValue=By.xpath("//span[text()='Total: ']//following::span[1]");
	By finalTitle=By.xpath("//div[@class='row item-details']/div");
	By finalValue=By.xpath("//div[@class='item-price']/span");
	By finalTotal=By.xpath("//div[@id='cart-total']//td[2]/span");
	public WebElement finalTotal() {
		return driver.findElement(finalTotal);
	}
	public WebElement finalTitle() {
		return driver.findElement(finalTitle);
	}
	public WebElement finalValue() {
		return driver.findElement(finalValue);
	}
	
	
	public WebElement totalValue() {
		return driver.findElement(totalValue);
	}
	public WebElement priceValue() {
		return driver.findElement(priceValue);
	}
	public WebElement titleName() {
		return driver.findElement(titleName);
	}
	public WebElement Search() {
		return driver.findElement(search);
	}
	public WebElement Search_Button() {

		return driver.findElement(search_btn);
	}
	public WebElement ScreenSize() {
		return driver.findElement(size);
	}
	public WebElement Product() {
		return driver.findElement(product);
	}
	public WebElement AddCart() {
		return driver.findElement(addcart);
	}
	public WebElement CheckOut() {
		return driver.findElement(checkout);
	}
	public WebElement Guest_Login() {
		return driver.findElement(guest_btn);
	}
	public WebElement VerifyProductText() {
		return driver.findElement(productdetails);
	}
	public WebElement VerifyPrice() {
		return driver.findElement(verifyprice);
	}
	public WebElement ItemCondition() {
		return driver.findElement(item);
	}
	public void javaScriptClick(WebElement element){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public void waitForElementVisibility(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}

