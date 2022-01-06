package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.netty.channel.pool.FixedChannelPool.AcquireTimeoutAction;

public class FaceBook_Assignment1 {

	public static void main(String args[])
	{
		ChromeDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		//Launch the chromebrowser
		 //Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		//Maximise the window
		driver.manage().window().maximize();
		
		//Add implicit wait
	    //	driver.manage().timeouts().implicitlyWait(100);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		driver.findElement(By.name("firstname")).sendKeys("sruthi");
		driver.findElement(By.name("lastname")).sendKeys("Priya");
		driver.findElement(By.name("reg_email__")).sendKeys("sruthi@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Sethuram");
		WebElement days =driver.findElement(By.id("day"));
		Select days_dropdown = new Select(days);
		days_dropdown.selectByValue("24");
		WebElement months =driver.findElement(By.id("month"));
		Select month_dropdown = new Select(months);
		month_dropdown.selectByVisibleText("Dec");
		
		//using size
		WebElement Years =driver.findElement(By.id("year"));
		Select year_dropdown = new Select(Years);
		int year_size=year_dropdown.getOptions().size();
		year_dropdown.selectByIndex(year_size-1);
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input[@name='sex']")).click();
		
		driver.close();
		
		
		
		
		
		
		
		
	}
	
	
}
