package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMain {
	
	private WebDriver driverWeb;
	WebElement submit;
	String expectedStatus = "";
	String status = "";

	@Before
	public void setupTest() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driverWeb = new ChromeDriver();
		driverWeb.manage().window().maximize();
		driverWeb.get("https://it.coinmill.com/BTC_EUR.html");
	}

	@Test
	public void test() throws InterruptedException {
		String input = "html/body/div[1]/div[3]/div/form/table[1]/tbody/tr[2]/td[1]/div/input";
		String convert = "html/body/div[1]/div[3]/div/form/table[2]/tbody/tr/td[1]/input";
		driverWeb.findElement(By.xpath("/" + input)).sendKeys("1");
		Thread.sleep(1000);
		driverWeb.findElement(By.xpath("/" + convert)).click();
		
		assertEquals(expectedStatus, status);
		
		
	}

}
