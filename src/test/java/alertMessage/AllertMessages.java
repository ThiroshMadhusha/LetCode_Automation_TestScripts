package alertMessage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AllertMessages {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://letcode.in/alert");
		
		/**
		 * Accept Allert 
		 * OK button Only
		 */
		driver.findElement(By.xpath("//button[@id='accept']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		String textAcceptationAlert = alert.getText();
		System.out.println("Alert Message Text : " + textAcceptationAlert);
		alert.accept();
		//come back to default page
		driver.switchTo().defaultContent();

		Thread.sleep(2000);
		/**
		 * Confirmation Button
		 * OK and Cancell Button Both
		 */
		//ok button
		driver.findElement(By.xpath("//button[@id='confirm']")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		String textConfirmationAlert = alert.getText();
		System.out.println("Alert Message Text : " + textConfirmationAlert);
		alert.accept();
		driver.switchTo().defaultContent();
		
		//cancell button
		driver.findElement(By.xpath("//button[@id='confirm']")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		String textCansalationAlert = alert.getText();
		System.out.println("Alert Message Text : " + textCansalationAlert);
		alert.dismiss();
		driver.switchTo().defaultContent();
		
		/**
		 * Prompt Alerts
		 */
		driver.findElement(By.xpath("//button[@id='prompt']")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		String alertText = alert.getText();
		System.out.println("Alert Message Text : " + alertText);
		alert.sendKeys("Thirosh");
		alert.accept();
		
		Thread.sleep(2000);
		
		String alertMessage = driver.findElement(By.xpath("//p[@id='myName']")).getText();
		System.out.println("Successfull Message : " + alertMessage);
		
		/**
		 * sweet alert / modern alerts
		 */
		driver.findElement(By.xpath("//button[@id='modern']")).click();
		String alertMessageText = driver.findElement(By.xpath("//p[@class='title']")).getText();
		System.out.println("Alert Message : " + alertMessageText);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		Thread.sleep(2000);

		driver.quit();
		
	}

}
