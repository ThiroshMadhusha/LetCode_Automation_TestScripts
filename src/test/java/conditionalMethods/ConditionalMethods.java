package conditionalMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * These commands will return the boolean values
 * isDisplayed() --> used to check whether an element is displayed on the webpage or not
 * 
 * isEnable() --> used to check whether an element is enable or not
 * This method used for disable checkbox, disable radio buttons and disable textbox
 * 
 * isSelected() --> used to check whether an element is selected or not. 
 * This method mostly used in radio button, check boxes and dropdown methods
 */

public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		//search field
		boolean searchFieldStatus = driver.findElement(By.xpath("//input[@id='small-searchterms']")).isDisplayed();
		System.out.println("Search Bar Display or Not : " + searchFieldStatus);
		searchFieldStatus = driver.findElement(By.xpath("//input[@id='small-searchterms']")).isEnabled();
		System.out.println("Search Bar Enable or Not : " + searchFieldStatus);
		
		Thread.sleep(2000);
		
		//radio button
		boolean redioButtonStatus = driver.findElement(By.xpath("//input[@id='gender-male']")).isDisplayed();
		System.out.println("Radio Button is Display or Not : " + redioButtonStatus);
		redioButtonStatus = driver.findElement(By.xpath("//input[@id='gender-male']")).isEnabled();
		System.out.println("Radio Button is Enable or Not : " + redioButtonStatus);
		//click radio button
		WebElement clickRedioButtonStatus = driver.findElement(By.xpath("//input[@id='gender-male']"));
		clickRedioButtonStatus.click();
		redioButtonStatus = driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected();
		System.out.println("Radio Button is Selected or Not : " + redioButtonStatus);
		
		Thread.sleep(2000);

		//text fields
		boolean testFieldStatus = driver.findElement(By.xpath("//input[@id='FirstName']")).isDisplayed();
		System.out.println("Text Field is Display or Not : " + testFieldStatus);
		testFieldStatus = driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		System.out.println("Text Field is Enable or Not : " + testFieldStatus);
		
		Thread.sleep(2000);

		//checkboxes
		boolean checkBoxStatus = driver.findElement(By.xpath("//input[@id='Newsletter']")).isDisplayed();
		System.out.println("Check Box is Display or Not : " + checkBoxStatus);
		checkBoxStatus = driver.findElement(By.xpath("//input[@id='Newsletter']")).isEnabled();
		System.out.println("Check Box is Enable or Not : " + checkBoxStatus);
		checkBoxStatus = driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();
		System.out.println("Check Box is Selected or Not : " + checkBoxStatus);
		
		Thread.sleep(2000);

		//dropdown
		boolean dropdownButtonStatus = driver.findElement(By.xpath("//select[@id='customerCurrency']")).isDisplayed();
		System.out.println("DropDown is Display or Not : " + dropdownButtonStatus);
		dropdownButtonStatus = driver.findElement(By.xpath("//select[@id='customerCurrency']")).isEnabled();
		System.out.println("DropDown is Enable or Not : " + dropdownButtonStatus);
		dropdownButtonStatus = driver.findElement(By.xpath("//select[@id='customerCurrency']")).isSelected();
		System.out.println("DropDown is Selected or Not : " + dropdownButtonStatus);
		
		System.out.println("All Statements are Passed...!");
		driver.quit();
	}

}
