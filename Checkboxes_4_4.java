package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Checkboxes_4_4 {

	public static void main(String args[])
	{
      //	http://leafground.com/pages/checkbox.html
		
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/checkbox.html");
		
		//select all the languages known
		
		driver.findElement(By.xpath("//div[text()='Java']/input")).click();
		driver.findElement(By.xpath("//div[text()='C']/input")).click();
		driver.findElement(By.xpath("//div[text()='C++']/input")).click();
		
		//confirm if selenium is checked
		
		System.out.println("Selenium is checked? :"+ driver.findElement(By.xpath("//div[text()='Selenium']/input")).isSelected());
		
		//deselect the selected one
		if(driver.findElement(By.xpath("//div[text()='Not Selected']")).isSelected())
			driver.findElement(By.xpath("//div[text()='Not Selected']")).click();
		
		if(driver.findElement(By.xpath("//div[text()='I am Selected']/input")).isSelected())
			driver.findElement(By.xpath("//div[text()='I am Selected']/input")).click();
						
        //select all options
		driver.findElement(By.xpath("//div[text()='Option 1']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 2']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 3']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 4']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 5']/input")).click();
		
	}
	
	
	
}

