package org.itstep.service;

import java.util.concurrent.TimeUnit;

import org.itstep.dao.GoodActionDAO;
import org.itstep.dao.GoodDAO;
import org.itstep.model.Account;
import org.itstep.model.Good;
import org.itstep.model.GoodAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BotService {
	
	private static final String BASE_URL = "https://www.amazon.com";	
	
	public static WebDriver getChromeDriver() {
		
		String mainDir = System.getProperty("user.dir");
		String sep = System.getProperty("file.separator");
		
		String driverPath = mainDir + sep + "lib" + sep + "chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		
		Timer.waitSec(3);
		
		return driver;
	}
	
	public static WebDriver registerAccount(WebDriver driver, Account account) {
		
		driver.get(BASE_URL);
		Timer.waitSec(5);
		
		WebElement registerDivElement = driver.findElement(By.id("nav-flyout-ya-newCust"));
		WebElement registerLinkElement = registerDivElement.findElement(By.tagName("a"));
		String registerlink = registerLinkElement.getAttribute("href");
		
		driver.get(registerlink);
		Timer.waitSec(5);		
		
		WebElement inputNameElement = driver.findElement(By.id("ap_customer_name"));
		inputNameElement.sendKeys(account.getFirstName() + " " + account.getLastName());
		Timer.waitSec(5);
		
		WebElement inputEmailElement = driver.findElement(By.id("ap_email"));
		inputEmailElement.sendKeys(account.getEmail());
		Timer.waitSec(5);
		
		WebElement inputPasswordElement = driver.findElement(By.id("ap_password"));
		inputPasswordElement.sendKeys(account.getPassword());
		Timer.waitSec(5);
		
		WebElement inputCheckElement = driver.findElement(By.id("ap_password_check"));
		inputCheckElement.sendKeys(account.getPassword());
		Timer.waitSec(5);
		
		WebElement inputSubmitElement = driver.findElement(By.id("continue"));
		inputSubmitElement.submit();
		
		Timer.waitSec(5);
		String currentUrl = driver.getCurrentUrl();
		driver.get(currentUrl);
		
		if(driver.getPageSource().contains("Hello, "))
			return driver;		
		
		driver.quit();
		return null;
	}
	
	public static WebDriver addGoodToCart(WebDriver driver, Good good, GoodAction goodAction) {		
		
		Timer.waitSec(5);
		
		WebElement inputSearchElement = driver.findElement(By.id("twotabsearchtextbox"));
		inputSearchElement.sendKeys(good.getAsin());
		Timer.waitSec(2);		
		inputSearchElement.submit();
		Timer.waitSec(5);		
		
		String goodXPath = "//div[@class='a-row a-spacing-none']//a[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']";
		WebElement goodUrlElement = driver.findElement(By.xpath(goodXPath));
		String goodUrl = goodUrlElement.getAttribute("href");		
		int indexToTrim = goodUrl.indexOf("/ref");
		goodUrl = goodUrl.substring(0, indexToTrim);		
		String goodName = goodUrlElement.getAttribute("title");	
		
		good.setShopUrl(goodUrl);
		good.setName(goodName);
		GoodDAO.save(good);
		
		goodAction.setAction("good name and url is received");
		goodAction.setActionTime(System.currentTimeMillis());
		GoodActionDAO.save(goodAction);
		
		driver.get(goodUrl);
		Timer.waitSec(5);
		
		WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-button-ubb"));
		addToCartBtn.submit();
		Timer.waitSec(5);
		
		String addCheckXPath = "//h1[@class='a-size-medium a-text-bold']";
		WebElement addedToCartCheck = driver.findElement(By.xpath(addCheckXPath));		
		if(addedToCartCheck.getText().equals("Added to Cart")) {
			goodAction.setAction("good is added to cart");
			goodAction.setActionTime(System.currentTimeMillis());
			goodAction.setIsAddedToCart(true);
			GoodActionDAO.save(goodAction);
			return driver;
		}
			
		goodAction.setAction("good is not added to cart");
		goodAction.setActionTime(System.currentTimeMillis());		
		GoodActionDAO.save(goodAction);
		return null;
	}
}