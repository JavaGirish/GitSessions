import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartBasicSearch {
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Udemy\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com"); //Browser launched
		
	}

	@Test
	public void searchProduct() {
		
		System.out.println(driver.getTitle()); //Print page title
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='_3Njdz7']"))).build().perform();
		driver.findElement(By.xpath("//div[@class='_3Njdz7']//button[@class='_2AkmmA _29YdH8']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Speakers"); //Enter product
		driver.findElement(By.xpath("//button[@type='submit']")).click(); //Click Search

	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit()
	}

}
