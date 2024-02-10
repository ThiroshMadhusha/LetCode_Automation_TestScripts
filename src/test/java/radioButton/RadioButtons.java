package radioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://letcode.in/radio");
		
		/**
		 * Check both can select or no
		 */
		Thread.sleep(2000);
		WebElement yesRadioButton = driver.findElement(By.xpath("//input[@id='yes']"));
		WebElement noRadioButton = driver.findElement(By.xpath("//input[@id='no']"));
		noRadioButton.click();
		yesRadioButton.click();
		
		if(yesRadioButton.isSelected() || (noRadioButton.isSelected())) {
			System.out.println("Any one Button can Slected...!");
		}else {
			System.out.println("Any of Buttons are cannot selected...!");
		}
	
		/**
		 * Select only One Radio Button Confirmation
		 */
		Thread.sleep(2000);
		WebElement yesOneButton = driver.findElement(By.xpath("//input[@id='one']"));
		WebElement noOneButton = driver.findElement(By.xpath("//input[@id='two']"));
		yesOneButton.click();
		noOneButton.click();
		
		if(yesOneButton.isSelected() && (noOneButton.isSelected())) {
			System.out.println("Only One Button Should be slected. Bug Found...!");
		}else {
			System.out.println("Only One Button Should be slected. No Bug Found...!");
		}
		
		/**
		 * Both select Button Bug
		 */
		Thread.sleep(2000);
		WebElement yesButton = driver.findElement(By.xpath("//input[@id='nobug']"));
		WebElement noButton = driver.findElement(By.xpath("//input[@id='bug']"));
		yesButton.click();
		noButton.click();
		
		if(yesButton.isSelected() && (noButton.isSelected())) {
			System.out.println("Bug Found...!");
		}else {
			System.out.println("No Bug Found...!");
		}
		
		/**
		 * Find which radio button is Selected
		 */
		Thread.sleep(2000);
		WebElement fooSelected = driver.findElement(By.xpath("//input[@id='foo']"));
		WebElement barSelected = driver.findElement(By.xpath("//input[@id='notfoo']"));
		fooSelected.isSelected();
		barSelected.isSelected();
		
		if(fooSelected.isSelected()) {
			System.out.println("Foo Radio Button is Selected.");
		}else if(barSelected.isSelected()) {
			System.out.println("Bar Radio Button is Selected.");
		}else {
			System.out.println("No Buttons are Selected...!");
		}
		
		/**
		 * Confirm last radio button id Disable
		 */
		Thread.sleep(2000);
		WebElement goingRadioButton = driver.findElement(By.xpath("//input[@id='going']"));
		WebElement notgoingRadioButton = driver.findElement(By.xpath("//input[@id='notG']"));
		WebElement maybeRadioButton = driver.findElement(By.xpath("//input[@id='maybe']"));
		
		goingRadioButton.isSelected();
		notgoingRadioButton.isSelected();
		maybeRadioButton.isSelected();
		
		if(goingRadioButton.isSelected()) {
			System.out.println("Going Radio Button is Selected.");
		}else if(notgoingRadioButton.isSelected()) {
			System.out.println("Not Going Radio Button is Selected.");
		}else if(!maybeRadioButton.isSelected()) {
			System.out.println("Maybe Radio Button is Selected.");
		}else {
			System.out.println("Fail");
		}
		
		/**
		 * CheckBox is Selected
		 */
		Thread.sleep(2000);
		WebElement checkBoxSelect = driver.findElement(By.xpath("//label[contains(text(),'Remember me')]/input"));
		checkBoxSelect.isSelected();
		
		if(checkBoxSelect.isSelected()) {
			System.out.println("Check box is Selected.");
		}else {
			System.out.println("Check box is not Selected.");
		}
		
		/**
		 * T&C can select
		 */
		Thread.sleep(2000);
		WebElement acceptSelect = driver.findElement(By.xpath("//label[contains(text(),'I agree to the')]/input"));
		acceptSelect.click();
		acceptSelect.isSelected();
		
		if(acceptSelect.isSelected()) {
			System.out.println("User can Click T&C Checkbox");
		}else {
			System.out.println("User can not Click T&C Checkbox");
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}
