import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class goibibo {

	public static WebDriver driver = null;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Udemy\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@Test
	public void test1() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Round trip']")).click();
		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Mumbai");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("react-autosuggest-1"))));

//		WebElement depBox = driver.findElement(By.id("react-autosuggest-1"));
//		waitforElement(depBox, 30);

		WebElement depCity = driver.findElement(By.xpath("//span[contains(text(),'BOM')]"));
		waitforElement(depCity, 30);
		depCity.click();

		driver.findElement(By.id("gosuggest_inputDest")).sendKeys("Bangalore");
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("react-autosuggest-1"))));

		WebElement retCity = driver.findElement(By.xpath("//span[contains(text(),'BLR')]"));
		waitforElement(retCity, 30);
		retCity.click();
		WebElement cal = driver.findElement(By.xpath("//div[contains(@class,'DayPicker-Month')]"));

		waitforElement(cal, 10);
		driver.findElement(By.id("fare_20190629")).click();
		driver.findElement(By.xpath("//input[@placeholder='Return']")).click();
		// driver.findElement(By.xpath("//span[contains(@class,'next')]")).click();
		driver.findElement(By.id("fare_20190710")).click();
		driver.findElement(By.id("pax_link_common")).click();
		driver.findElement(By.id("childPaxPlus")).click();
		driver.findElement(By.id("adultPaxPlus")).click();
		Select s1 = new Select(driver.findElement(By.id("gi_class")));
		s1.selectByVisibleText("Premium Economy");
		driver.findElement(By.id("gi_search_btn")).click();

	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();

		}
	}

	public static void waitforElement(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

}
