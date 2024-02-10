package register;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterAllTestCases {

	/**
	 * TestNG --> public void testCaseName(){} 
	 * @param args
	 * @throws InterruptedException
	 */
	@Test(priority=1)
	public void registerAccountWithAllMandatoryFields() {
		
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
		
		WebElement clickContinueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
		clickContinueBtn.click();
		
		//Checkin whetehr User Successfully Login or Not
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
		
		driver.quit();
	}

	@Test(priority=2)
	public void registerAccountWithAllFields() {
		
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
		System.out.println("User Register Successfull...!");
		Assert.assertTrue(checkLogoutOption.isDisplayed());
		
		WebElement continueButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		continueButton.click();

		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "My Account";
		Assert.assertEquals(actualPageTitle,expectedPageTitle);
		
		driver.quit();
		
	}
	
	@Test(priority=3)
	public void registerWithoutProvidingAnyFields() {
		
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
		
		driver.quit();
	}
	
	@Test(priority=4)
	public void registerAccountBySelectingYesNewsLetterOption() throws InterruptedException {
		
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
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	@Test(priority=5)
	public void registerAccountBySelectNoNewsLetterOption() throws InterruptedException {
		
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
		
		WebElement subscribeRadioBtnNo = driver.findElement(By.xpath("//input[@value='0']"));
		subscribeRadioBtnNo.click();
		
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
		
		boolean NewsLetterSubscriptionNo = driver.findElement(By.xpath("//input[@value='0']")).isSelected();
		Assert.assertTrue(NewsLetterSubscriptionNo);
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	@Test(priority=6)
	public void differentRegisterAccountPageNavigate() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		String title = driver.getTitle();
		System.out.println("Page Title Is : " + title);
		
		WebElement myAccountDropDownMenu = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		myAccountDropDownMenu.click();
		
		WebElement cickRegisterOption = driver.findElement(By.linkText("Register"));
		cickRegisterOption.click();
		
		//Verify by Page Title
		String actualTitle = driver.getTitle();
		String expectedTitle = "Register Account";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Verify by Page Title Test Case is Pass!!!");
		Thread.sleep(2000);
		
		//Verify by through the Login Page
		//Once create webelement we can use same things without create WebElement
		myAccountDropDownMenu = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		myAccountDropDownMenu.click();
		
		WebElement loginOption = driver.findElement(By.linkText("Login"));
		loginOption.click();
		
		WebElement continueButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		continueButton.click();
		
		actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Verify by Through the Login Page Test Case is Pass!!!");
		Thread.sleep(2000);
		
		//Verify by Right Side of Login Page SideBar 
		myAccountDropDownMenu = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		myAccountDropDownMenu.click();
		
		loginOption = driver.findElement(By.linkText("Login"));
		loginOption.click();
		
		WebElement registerColumnOption = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Register']"));
		registerColumnOption.click();
		
		actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Verify by Through the Login Page Side Bar Register Option Test Case is Pass!!!");
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(priority=7)
	public void registerAccountByProvidingDifferentPasswordMisMatches() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");

		String title = driver.getTitle();
		System.out.println("Page Title Is : " + title);
		
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
		confirmField.sendKeys("12345");
		
		WebElement subscribeRadioBtnNo = driver.findElement(By.xpath("//input[@value='0']"));
		subscribeRadioBtnNo.click();
		
		WebElement privacyPolicyField = driver.findElement(By.xpath("//input[@name='agree']"));
		privacyPolicyField.click();
		
		WebElement clickContinueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
		clickContinueBtn.click();
		
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
	
	@Test(priority=8)
	public void registerDuplicateAccountWithSameEmail() throws InterruptedException {
		
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
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
		
		if(actualWarningMessage.equals(expectedWarningMessage)) {
			System.out.println("Test Case Pass! Display an Actual Warning Message...!");
		}else {
			System.out.println("Test Case Fail! Not Display an Actual Warning Message...!");
		}
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(priority=9)
	public void ddd() {
		
	}
	
}
