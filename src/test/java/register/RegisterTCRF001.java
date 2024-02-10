package register;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * registerAccountWithAllMandatoryFields
 */

public class RegisterTCRF001 {

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
		
		Thread.sleep(2000);
		//span[normalize-space()='My Account']
		WebElement myAccountDropDownMenu = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		myAccountDropDownMenu.click();
		
		WebElement cickRegisterOption = driver.findElement(By.linkText("Register"));
		cickRegisterOption.click();
		
		WebElement firstNameField = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		firstNameField.sendKeys("Thirosh");

		WebElement lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.sendKeys("Madhusha");
		
		/**
		 * Generate Email With Date Function
		 * Remove all Sysmbols and Spaces using replace command
		 */
		
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
		
		WebElement privacyPolicyField = driver.findElement(By.xpath("//input[@name='agree']"));
		privacyPolicyField.click();
		
		Thread.sleep(2000);

		WebElement clickContinueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
		clickContinueBtn.click();
		
		Thread.sleep(3000);
		//Checkin whetehr User Successfully Login or Not
		
		WebElement myAccountDropDownMenus = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		myAccountDropDownMenus.click();
		
		Thread.sleep(1000);
		WebElement checkLogoutOption = driver.findElement(By.linkText("Logout"));
		checkLogoutOption.isDisplayed();
		System.out.println("Login Successfull...!");
		
		Assert.assertTrue(checkLogoutOption.isDisplayed());
		
		Thread.sleep(3000);

		WebElement continueButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		continueButton.click();
		
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "My Account";
		
		if(actualPageTitle.equals(expectedPageTitle)) {
			System.out.println("User Has Successfully Navigate to The My Account Page..!");
		}else {
			System.out.println("User is ot Navigate to The My Account Page. Try Again...!");
		}
//		String actualPageTitle = driver.getTitle();
//		String expectedPageTitle = "My Account";
//		Assert.assertEquals(actualPageTitle,expectedPageTitle);
		
		Thread.sleep(3000);
		driver.quit();
	}

}
