package colorButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPractice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://letcode.in/buttons");
		
		//click button
		WebElement goHomeButton = driver.findElement(By.xpath("//button[@id='home']"));
		goHomeButton.click();
		
		Thread.sleep(2000);
		//browser back option
		driver.navigate().back();
		
		//get X and Y co-ordinate
		WebElement findLocationButton = driver.findElement(By.id("position"));
		Point point = findLocationButton.getLocation();
		System.out.println("X co-ordinate of button : " + point.getX());
		System.out.println("Y co-ordinate of button : " + point.getY());
		
		//2nd way
		Rectangle rect = findLocationButton.getRect();
		System.out.println("X co-ordinate of button : " + rect.getX());
		System.out.println("Y co-ordinate of button : " + rect.getY());
		
		//find button color in css 
		WebElement buttonColor = driver.findElement(By.xpath("//button[@id='color']"));
		String colorOfButton = buttonColor.getCssValue("background-color");
		System.out.println("Button CSS Color is : " + colorOfButton);
		
		//get size of button
		WebElement heightWidthButton = driver.findElement(By.id("property"));
		Dimension sizeOfButton = heightWidthButton.getSize();
		System.out.println("Height and Width of Button : " +sizeOfButton.height);
		System.out.println("Height and Width of Button : " +sizeOfButton.width);
		
		//2nd way
		Rectangle r = heightWidthButton.getRect();
		System.out.println("Height and Width of Button : " + r.height);
		System.out.println("Height and Width of Button : " + r.width);
		
		//disable button
		WebElement disableButton = driver.findElement(By.xpath("//div[5]//div[1]//button[1]"));
		boolean status = disableButton.isEnabled();
		System.out.println("Button Status : " + status);
		
		//click and hold button
		Actions action= new Actions(driver);
		WebElement holdButton = driver.findElement(By.xpath("//h2[normalize-space()='Button Hold!']"));
		action.clickAndHold(holdButton).perform();
		//hold 4s and relese
		Thread.sleep(4000);
		action.release().perform();
		Thread.sleep(4000);

		System.out.println("Test Pass!!!");
		driver.quit();
	}

}
