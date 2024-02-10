package register;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * registerAccountWithAllFields
 */

public class RegisterTCRF003 {

	/**
	 * TestNG --> public void sampleName(){} 
	 * @param args
	 * @throws InterruptedException
	 */
	@Test
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		String title = driver.getTitle();
		System.out.println("Page Title Name : " + title);
		
		WebElement myAccountDropDownMenu = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		myAccountDropDownMenu.click();
		
		WebElement cickRegisterOption = driver.findElement(By.linkText("Register"));
		cickRegisterOption.click();
		
		WebElement firstNameField = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		firstNameField.sendKeys("Thirosh");

		WebElement lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.sendKeys("Madhusha");
		
		Date date = new Date();
		String email = date.toString().replace(" ", "").replace(":", "") + "@gmail.com";
		
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys(email);
		
		WebElement mobileNoField = driver.findElement(By.id("input-telephone"));
		mobileNoField.sendKeys("1232132132");
		
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='input-password']"));
		passwordField.sendKeys("1234");
		
		WebElement confirmField = driver.findElement(By.xpath("//input[@id='input-confirm']"));
		confirmField.sendKeys("1234");
		
		WebElement subscribeRadioBtn = driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']"));
		subscribeRadioBtn.click();
		
		WebElement privacyPolicyField = driver.findElement(By.xpath("//input[@name='agree']"));
		privacyPolicyField.click();
		
		WebElement clickContinueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
		clickContinueBtn.click();
		
		WebElement myAccountDropDownMenus = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		myAccountDropDownMenus.click();
		
		WebElement checkLogoutOption = driver.findElement(By.linkText("Logout"));
		checkLogoutOption.isDisplayed();
		System.out.println("Register Successfull...!");
		Assert.assertTrue(checkLogoutOption.isDisplayed());
		
		WebElement continueButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		continueButton.click();

		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "My Account";
		Assert.assertEquals(actualPageTitle,expectedPageTitle);
		
		Thread.sleep(2000);
		driver.quit();
	}

}
