package week2.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class DuplicateLead_Ass2_3 {
	public static void main( String[] Args) throws InterruptedException
	{
		
		/*http://leaftaps.com/opentaps/control/main **/
 	    ChromeDriverManager.chromedriver().setup();
		ChromeDriver Driver =new ChromeDriver();
		//load url
		Driver.get("http://leaftaps.com/opentaps/control/main");
		
		//maximize
		Driver.manage().window().fullscreen();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//enter username and password
		Driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		Driver.findElement(By.id("password")).sendKeys("crmsfa");
		Driver.findElement(By.className("decorativeSubmit")).click();
		
		
		//click CRM/SFA -> leads -> find lead
				Driver.findElement(By.linkText("CRM/SFA")).click();
				Driver.findElement(By.linkText("Leads")).click();
				Driver.findElement(By.linkText("Find Leads")).click();
		//mail-> enter mail -> capture name of first resulting lead ->click on first lead
				Driver.findElement(By.xpath("//span[text()='Email']")).click();
				Driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("sruthi@gmail.com");
				Driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				Thread.sleep(1000);
				String FirstLead = Driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")).getText();
			    System.out.println("The first lead is"+ FirstLead);
				Driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
			    
	    // click Duplicate Lead 
			    Driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
			    
	    // Verify the title as 'Duplicate Lead' 
			    System.out.println( Driver.getTitle());
			   if( Driver.getTitle().contains("Duplicate Lead"))
				   System.out.println("Title is proper " +Driver.getTitle());
			   else
				   System.out.println("Title is not Duplicate Lead");
			    
		//Click Create Lead	    
			    Driver.findElement(By.xpath("//input[@name='submitButton']")).click();
			    Thread.sleep(1000);
			 
		//Confirm the duplicated lead name is same as captured name
			   if( Driver.findElement(By.id("viewLead_firstName_sp")).getText().contains(FirstLead))
				   System.out.println("Duplicate is created for"+Driver.findElement(By.id("viewLead_firstName_sp")).getText());
			   else
				   System.out.println("FrstLead"+ FirstLead + "duplicate is not created"+ Driver.findElement(By.id("viewLead_firstName_sp")).getText());
		//Close the browser (Do not log out)
			  Driver.close();
		
		
	}
	
}
