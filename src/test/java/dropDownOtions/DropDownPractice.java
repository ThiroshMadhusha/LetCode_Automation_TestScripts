package dropDownOtions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPractice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://letcode.in/dropdowns");
		
		WebElement selecDropDownField = driver.findElement(By.xpath("//select[@id='fruits']"));
		Select select = new Select(selecDropDownField);
		select.selectByVisibleText("Apple");
		
		//print all options
		WebElement languageField = driver.findElement(By.xpath("//select[@id='lang']"));
		select = new Select(languageField);
		List<WebElement> options = select.getOptions();
		int noOfOptions = options.size();
		int lastOptionIndex = noOfOptions-1;
		select.selectByIndex(lastOptionIndex);
		
		for(WebElement option : options) {
			System.out.println(option.getText());
		}
		
		//select value and print value
		WebElement countryField = driver.findElement(By.xpath("//select[@id='country']"));
		select = new Select(countryField);
		select.selectByValue("India");
		System.out.println("Selected Vaue Is : " + select.getFirstSelectedOption().getText());
		
		Thread.sleep(2000);
		driver.quit();
	}

}
