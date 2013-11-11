package com.zenika.cakefactory;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertNotEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author gtinon
 */
public class CakeFactoryControlIT {

	private static HtmlUnitDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("http://localhost:8080");

		WebElement zeCake = driver.findElementById("zeCake");
		assertEquals("", zeCake.getText());

		WebElement zeForm = driver.findElementById("zeForm");
		zeForm.click();

		// Thread.sleep(5000);

		zeCake = driver.findElementById("zeCake");
		assertNotEquals("", zeCake.getText());
	}

}
