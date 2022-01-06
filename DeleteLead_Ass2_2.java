package week2.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class DeleteLead_Ass2_2 {

	public static void main(String[] args ) throws InterruptedException {
	/*http://leaftaps.com/opentaps/control/main */
	 
	//Delete Lead:
	//1	Launch the browser
	ChromeDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main"); 
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //2	Enter the username
	//3	Enter the password
	//4	Click Login
	driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	
	//5	Click crm/sfa link
	driver.findElement(By.xpath("//a[contains(text(),\"CRM/SFA\")]")).click();
	
	//6	Click Leads link
	driver.findElement(By.linkText("Leads")).click();
	//7	Click Find leads
	driver.findElement(By.linkText("Find Leads")).click();
	
	//8	Click on Phone
	driver.findElement(By.xpath("//span[contains(text(),\"Phone\")]")).click();
	
	//9	Enter phone number
	//driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("15");
	//driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("2");
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9940563498");
	
	//10	Click find leads button
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	
	//11	Capture lead ID of First Resulting lead
	String lead_value= driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).getText();
	System.out.println("lead is "+lead_value);
	//12	Click First Resulting lead
	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
	//13	Click Delete
	driver.findElement(By.linkText("Delete")).click();
	
	//14	Click Find leads
	driver.findElement(By.linkText("Find Leads")).click();
			
	//15	Enter captured lead ID
	driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[1]")).sendKeys(lead_value);
	
	//16	Click find leads button
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	
	//17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
    String Result = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
    System.out.println("result is"+Result);
    
	//18	Close the browser (Do not log out)
    if (Result.contains("No records to display"))
       System.out.println("Deleted Lead is not displayed");
    else
    	 System.out.println("Deleted Lead is displayed");
	
	}
}
