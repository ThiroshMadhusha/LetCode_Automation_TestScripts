package inputFields;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputsPractice {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://letcode.in/edit");
		
		String title = driver.getTitle();
		System.out.println("Page Title is : " + title);

		Thread.sleep(2000);
		WebElement firstName = driver.findElement(By.xpath("//input[@id='fullName']"));
		firstName.sendKeys("Thirosh");

		Thread.sleep(2000);
		WebElement tabKey = driver.findElement(By.xpath("//input[@id='join']"));
		tabKey.sendKeys("teacher bn");
		tabKey.sendKeys(Keys.TAB);
		
		Thread.sleep(2000);
		String retriveText = driver.findElement(By.xpath("//input[@id='getMe']")).getAttribute("value");
		System.out.println("Retrive Attribute Value Is : " + retriveText);
		
		WebElement clearText = driver.findElement(By.xpath("//input[@id='clearMe']"));
		clearText.clear();

		Thread.sleep(2000);
		boolean enableDisableStatus = driver.findElement(By.xpath("//input[@id='noEdit']")).isEnabled();
		
		if(enableDisableStatus) {
			System.out.println("Field is Enable to Edit");
		}else {
			System.out.println("Field is Not Enable to Edit");
		}
		
		Thread.sleep(2000);
		WebElement readOnlyStatus = driver.findElement(By.xpath("//input[@id='dontwrite']"));
		readOnlyStatus.getAttribute("readonly");
		if(readOnlyStatus.equals("true")) {
			System.out.println("Confirm Text is ReadOnly State");
		}else {
			System.out.println("Confirm Text Field is Not a ReadOnly State");
		}
	}

}
