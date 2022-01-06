package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Button_4_1 {
	
	public static void main(String args[])
	{      //   http://leafground.com/pages/Button.html
		   //   http://leafground.com/pages/Link.html
		   //	http://leafground.com/pages/Image.html
		   //	http://leafground.com/pages/checkbox.html
		
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Button.html");
		
        driver.findElement(By.id("home")).click();
        driver.findElement(By.xpath("//img[@alt='Buttons']")).click();
        WebElement Position = driver.findElement(By.xpath("//button[text()='Get Position']"));
       
         //get position
       System.out.println("Position is "+ Position.getLocation());
       System.out.println("Position of x alone is "+ Position.getLocation().getX());
       System.out.println("Position of y alone is "+ Position.getLocation().getY());
       
       //get Css value color
      WebElement color = driver.findElement(By.id("color"));
      System.out.println("Color is "+ color.getCssValue("background-color"));
      
      //get size( height and width)
      WebElement size = driver.findElement(By.id("size"));
      System.out.println("Size is "+ size.getSize());
      System.out.println("Height is "+ size.getSize().getHeight());
      System.out.println("Width"+ size.getSize().getWidth());
      System.out.println("Color is "+ size.getCssValue("background-color"));
      
      
		
		
	}





}
