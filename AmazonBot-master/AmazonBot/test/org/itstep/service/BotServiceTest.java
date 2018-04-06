package org.itstep.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class BotServiceTest {

	@Test
	public void testGetChromeDriver() {
		
		WebDriver driver = BotService.getChromeDriver();
		
		assertNotNull(driver);
		
		driver.quit();

	}

}
