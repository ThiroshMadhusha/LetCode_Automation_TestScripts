package register;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegisterTCRF005 {

	public static void main(String[] args) {
		
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
		
		WebElement subscribeRadioBtnYes = driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']"));
		subscribeRadioBtnYes.click();
		
		WebElement privacyPolicyField = driver.findElement(By.xpath("//input[@name='agree']"));
		privacyPolicyField.click();
		
		WebElement clickContinueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
		clickContinueBtn.click();
		
		WebElement myAccountDropDownMenus = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		myAccountDropDownMenus.click();
		
		WebElement checkLogoutOption = driver.findElement(By.linkText("Logout"));
		checkLogoutOption.isDisplayed();
		System.out.println("User Register Successfull...!");
		Assert.assertTrue(checkLogoutOption.isDisplayed());
		
		WebElement continueButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		continueButton.click();

		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "My Account";
		Assert.assertEquals(actualPageTitle,expectedPageTitle);
		
		WebElement NewsLetterSubscribeOption = driver.findElement(By.xpath("//a[normalize-space()='Subscribe / unsubscribe to newsletter']"));
		NewsLetterSubscribeOption.click();
		
		boolean NewsLetterSubscriptionYes = driver.findElement(By.xpath("//input[@value='1']")).isSelected();
		Assert.assertTrue(NewsLetterSubscriptionYes);
		
		driver.quit();

	}

}
