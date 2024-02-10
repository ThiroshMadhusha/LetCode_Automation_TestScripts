package register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * registerWithoutProvidingAnyFields
 */
public class RegisterTCRF004 {

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
		
		WebElement clickContinueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
		clickContinueBtn.click();
		
		/**
		 * Error Message Display
		 */
		
		String actualFirstNameWarningMessage = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		String expectedFirstNameWarningMessage = "First Name must be between 1 and 32 characters!";
		Assert.assertEquals(actualFirstNameWarningMessage, expectedFirstNameWarningMessage);
		
		String actualLastNameWarningMessage = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		String expectedLastNameWarningMessage = "Last Name must be between 1 and 32 characters!";
		Assert.assertEquals(actualLastNameWarningMessage, expectedLastNameWarningMessage);
		
		String actualEmailWarningMessage = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		String expectedEmailWarningMessage = "E-Mail Address does not appear to be valid!";
		Assert.assertEquals(actualEmailWarningMessage, expectedEmailWarningMessage);
		
		String actualTelephoneWarningMessage = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		String expectedTelephoneWarningMessage = "Telephone must be between 3 and 32 characters!";
		Assert.assertEquals(actualTelephoneWarningMessage, expectedTelephoneWarningMessage);
		
		String actualPasswordWarningMessage = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		String expectedPasswordWarningMessage = "Password must be between 4 and 20 characters!";
		Assert.assertEquals(actualPasswordWarningMessage, expectedPasswordWarningMessage);
		
		String actualPolicyWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedPolicyWarningMessage = "Warning: You must agree to the Privacy Policy!";
		Assert.assertTrue(actualPolicyWarningMessage.contains(expectedPolicyWarningMessage));
		
	}

}
