package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class EditLead_Ass2_4 {
	public static void main(String[] args) throws InterruptedException {
	    
		
		// http://leaftaps.com/opentaps/control/main
			
 	    ChromeDriverManager.chromedriver().setup();
		ChromeDriver Driver =new ChromeDriver();
		//load url
		Driver.get("http://leaftaps.com/opentaps/control/main");
		
		//maximize
		Driver.manage().window().fullscreen();
		
		Driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		//enter username and password
		Driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		Driver.findElement(By.id("password")).sendKeys("crmsfa");
		Driver.findElement(By.className("decorativeSubmit")).click();
				
		//click CRM/SFA -> leads -> find lead
		Driver.findElement(By.linkText("CRM/SFA")).click();
		Driver.findElement(By.linkText("Leads")).click();
		Driver.findElement(By.linkText("Find Leads")).click();
		// Enter first name
		Driver.findElement(By.xpath(" //label[text()='First name:']/following::input[@name='firstName'][3]")).sendKeys("Sruthi");
		//	Click Find leads button
		Driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(1000);
		
		// Click on first resulting lead
		Driver.findElement(By.xpath("(//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]/a)[1]")).click();
		
		// Verify title of the page
		System.out.println(Driver.getTitle());
		
		//actual company name
		System.out.println("The old company is "+ Driver.findElement(By.id("viewLead_companyName_sp")).getText());
	
		// Click Edit
		Driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		// Change the company name
		Driver.findElement(By.id("updateLeadForm_companyName")).clear();
		Driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Amazon");
		
		// Click Update
		Driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		// Confirm the changed name appears
		System.out.println("The new company is "+ Driver.findElement(By.id("viewLead_companyName_sp")).getText());
		if(Driver.findElement(By.id("viewLead_companyName_sp")).getText().contains("Amazon"))
			System.out.println("Company is changed to Amazon");
		else
			System.out.println("Company is not changed to Amazon");
		
		// Close the browser (Do not log out)
		Driver.close();

}
	
	
	
}
