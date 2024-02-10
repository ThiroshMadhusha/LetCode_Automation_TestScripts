package register;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * registerAccountByProvidingDifferentPasswordMisMatches
 */

public class RegisterTCRF008 {

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

		Date date = new Date();
		String email = date.toString().replace(" ", "").replace(":", "") + "@gmail.com";
		
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys(email);
		
		driver.findElement(By.id("input-telephone")).sendKeys("1232132132");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		String expectedWarningMessage = "Password confirmation does not match password!";
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
		
		if(actualWarningMessage.equals(expectedWarningMessage)) {
			System.out.println("Test Case Pass! Display Actual Warning Error Message...!");
		}else {
			System.out.println("Test Case Fail! Not Display Actual Warning Error Message...!");
		}
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
