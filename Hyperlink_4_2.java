package week2.day2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Hyperlink_4_2 {
	
	public static void main(String args[])
	{   //http://leafground.com/pages/Link.html
		
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Link.html");
		
		//maximize
		driver.manage().window().maximize();
		
		//go to home
		 driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();
		 
		 //back to Hyperlink page
         driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();
         
         //find the url of the hyperlink
	     String url = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		 System.out.println("Find where am supposed to go without clicking me?" + " will take it to " + url);
		 
		 //check if the link is broken		 
		 String url2 = driver.findElement(By.linkText("Verify am I broken?")).getAttribute("href");
		 System.out.println("The broken link is "+ url2);
		 if(url2.contains("error.html"))
			 System.out.println("Link is broken");
		 else
			 System.out.println("Link is working fine");
		 
		 //go to hyperlink with same hypertext
         driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
		 driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();
		 
		  //find total no of links
		  List<WebElement> urls = driver.findElements(By.tagName("a"));
	      System.out.println("Total links on the Web Page: " + urls.size());
	      
	      driver.close();
	      
	       
	}

}
