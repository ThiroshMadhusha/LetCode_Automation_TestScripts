package register;

/**
 * registerDuplicateAccountWithSameEmail
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegisterTCRF009 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		String title = driver.getTitle();
		System.out.println("Page Title Is : " + title);
		
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Thirosh");
		driver.findElement(By.id("input-lastname")).sendKeys("Madhusha");
		driver.findElement(By.id("input-email")).sendKeys("abc123321@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1232132132");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(2000);
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
//		Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
		
		if(actualWarningMessage.equals(expectedWarningMessage)) {
			System.out.println("Test Case Pass! Display an Actual Warning Message...!");
		}else {
			System.out.println("Test Case Fail! Not Display an Actual Warning Message...!");
		}
		Thread.sleep(2000);
		driver.quit();

	}

}
