import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyntraCode {
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Girish Nair\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
	Map<String, Object> prefs = new HashMap<String, Object>();
	prefs.put("profile.default_content_setting_values.notifications", 2);
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("prefs", prefs);
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.myntra.com/");
	}
	
	@Test
	public void searchTest() {
	Actions action =new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//a[text()='Men']"))).build().perform();
	driver.findElement(By.linkText("Formal Shirts")).click();
	//Assert.assertEquals("Test Failed as Formal Shirts Link was not clicked", "Formal Shirts for Men - Buy Men's Formal Shirts Online | Myntra", driver.getTitle());
	Assert.assertEquals(driver.getTitle(), "Formal Shirts for Men - Buy Men's Formal Shirts Online | Myntra","Formal Shirts Link was not clicked");
	
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
