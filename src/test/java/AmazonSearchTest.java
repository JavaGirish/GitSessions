import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonSearchTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Udemy\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	@Parameters({"product"})
	@Test
	public void AmazonTitle(String product) {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(product);
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		Boolean b = driver.findElement(By.xpath("//a[@title='Vaseline Intensive Care Cocoa Glow Body Lotion, 400 ml']"))
				.isDisplayed();
		Assert.assertTrue(b);
		
	}

}
