package invisibleFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvisibleFrames {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://letcode.in/frame");
		
		String pageHeading = driver.findElement(By.xpath("//h1[contains(@class, 'is-title')]")).getText();
		System.out.println("Page Hedding Title Is : " + pageHeading);
		
		driver.switchTo().frame("firstFr");
		String pageTitle = driver.findElement(By.xpath("//h1[@class='title']")).getText();
		System.out.println("Page Hedding Title Is : " + pageTitle);

		WebElement firstName = driver.findElement(By.name("fname"));
		firstName.sendKeys("Thirosh");
		WebElement lastName = driver.findElement(By.name("lname"));
		lastName.sendKeys("Madhusha");
		
		WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Madhusha')]"));
		String message = element.getText();
		System.out.println("Output Message : " + message);
		
		//email field frame type
		WebElement childFrame = driver.findElement(By.xpath("//iframe[@class='has-background-white']"));
		driver.switchTo().frame(childFrame);
		WebElement emailField = driver.findElement(By.name("email"));
		emailField.sendKeys("adasd@gmail.com");
		Thread.sleep(2000);
		emailField.clear();
		Thread.sleep(2000);
		
		//only one child frame available
//		driver.switchTo().frame(1);
//		driver.findElement(By.name("email")).sendKeys("adasd1231@gmail.com");

		Thread.sleep(2000);
		driver.quit();
	}

}
