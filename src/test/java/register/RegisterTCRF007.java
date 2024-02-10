package register;

/**
 * differentRegisterAccountPageNavigate
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegisterTCRF007 {

	public static void main(String[] args) throws InterruptedException {
		
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

}
