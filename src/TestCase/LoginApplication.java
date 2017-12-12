package TestCase;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Object.eBayHomePage;
import junit.framework.AssertionFailedError;

public class LoginApplication {
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	// private static Logger Log = Logger.getLogger(Log.class.getName());

	@BeforeMethod
	public void befor() throws IOException {

		// Process p = Runtime.getRuntime().exec("cmd /f killChrome.bat", null,
		// new File("F:\\selenium code\\AutomationExercise\\killChrome.bat"));
	}

	@Test

	public void VerifyProductItems() throws Exception {
		try {
			String timeStamp;
			File screenShotName;
			report = new ExtentReports("F:\\Report\\Report.html");
			logger = report.startTest("VerifyProductItems");
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream("F:\\selenium code\\AutomationExercise\\datadriver.properties");
			prop.load(fis);
			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			driver.get(prop.getProperty("url"));
			logger.log(LogStatus.PASS, "Broswer Started");

			Assert.assertEquals("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay", driver.getTitle(),
					"Strings are not matching");
			
			eBayHomePage hp = new eBayHomePage(driver);
			logger.log(LogStatus.PASS, "Search Functionlity");
			hp.Search().sendKeys(prop.getProperty("search"));

			hp.Search_Button().click();
			logger.log(LogStatus.PASS, "Search Button click");
			hp.waitForElementVisibility(hp.ScreenSize());
			hp.javaScriptClick(hp.ScreenSize());
			logger.log(LogStatus.PASS, "Click on Screen Size link");
			hp.waitForElementVisibility(hp.Product());
			hp.Product().click();
			logger.log(LogStatus.PASS, "Click on Product");

			Assert.assertEquals("New", hp.ItemCondition().getText(), "Item is present");
			System.out.println(hp.VerifyProductText().getText());
			logger.log(LogStatus.PASS, "Item Text");
			String productName = hp.VerifyProductText().getText();
			
			System.out.println(hp.ItemCondition().getText());

			if (hp.ItemCondition().getText() != null) {
				System.out.println("item Present");
			} else {
				System.out.println("Item is not present");
			}
			logger.log(LogStatus.PASS, "Item is present");
			String price = hp.VerifyPrice().getText();
			logger.log(LogStatus.PASS, "Verify price");
			Assert.assertTrue(
					price.startsWith("US $") && price.substring(price.length() - 3, price.length() - 2).equals("."),
					"Price doesnot match the pattern required");

			System.out.println(hp.VerifyPrice().getText());
			hp.AddCart().click();
			logger.log(LogStatus.PASS, "Click on Add cart button");

			hp.waitForElementVisibility(hp.CheckOut());
			String totalValue = hp.totalValue().getText();
			String titleName = hp.titleName().getText();
			String priceValue = hp.priceValue().getText();
			Assert.assertTrue(price.contains(totalValue), "Price and Total value are matching");
			logger.log(LogStatus.PASS, "Price and Total value are matching");
			Assert.assertEquals(totalValue, priceValue, "total value and price value are matching");
			logger.log(LogStatus.PASS, "total value and price value are matching");
			Assert.assertEquals(productName, titleName, "Product title are matching");
			logger.log(LogStatus.PASS, "Product title are matching");
			hp.CheckOut().click();
			logger.log(LogStatus.PASS, "Click on Checkout button");

			hp.Guest_Login().click();
			logger.log(LogStatus.PASS, "Click on Guest login button");
			String finalValue = hp.finalValue().getText();
			String finalTitle = hp.finalTitle().getText();
			String finalTotal = hp.finalTotal().getText();
			Assert.assertTrue(price.contains(finalTotal), "Price and Total value are matching");
			logger.log(LogStatus.PASS, "Price and Total value are matching");
			Assert.assertEquals(totalValue, finalValue, "total value and price value are matching");
			logger.log(LogStatus.PASS, "total value and price value are matching");
			Assert.assertEquals(productName, finalTitle, "Product title are matching");
			logger.log(LogStatus.PASS, "Product title are matching");
		
			logger.log(LogStatus.PASS, "Product Item verified");
			hp.getscreenshot();
			driver.close();
		}

		catch (Exception e) {

			Assert.fail("Exception in test " + e.toString());
		}
		report.endTest(logger);
		report.flush();
		
	}

}
