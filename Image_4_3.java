package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Image_4_3 {

	public static void main(String[] args)
	{
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Image.html");
		
		 //go to home page
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following::img[1]")).click();
		
		driver.findElement(By.xpath("//h5[text()='Image']")).click();
		
		//how to find if a img is broken
		
		
		
		//click on the image
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following::img[3]")).click();
		
		 
		 
		
	}



}


