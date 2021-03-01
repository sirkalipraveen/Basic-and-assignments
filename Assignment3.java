package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
  // 1)Launch the browser
		    ChromeDriver driver=new ChromeDriver();
		    driver.get("http://leaftaps.com/opentaps/control/main");
		    driver.manage().window().maximize();
 //  2)Enter the username
		    driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
 //	 3)Enter the password
		    driver.findElement(By.id("password")).sendKeys("crmsfa");
//   4)Click the login
		    driver.findElement(By.className("decorativeSubmit")).click();
//   5)Click CRM/SFA link
		    driver.findElementByPartialLinkText("CRM").click();
//   6)Click Leads link
		    driver.findElement(By.linkText("Leads")).click();
//   7)Click Find Leads link 
		    driver.findElement(By.linkText("Find Leads")).click();
//   8)CLick on Phone
		    driver.findElement(By.xpath("//span[text()='Phone']")).click();
//   9)Enter Phone number 99	
			driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='phoneNumber']")).sendKeys("88");
            Thread.sleep(30000);
//   10)Click the Fine Leads button	
		    driver.findElement(By.xpath("(//button[text()='Find Leads'])")).click();
		    Thread.sleep(20000);
//   11)Capture lead ID of resulting lead
		    WebElement LeadIDElement=driver.findElement(By.xpath("//a[text()=10288]"));
			String LeadID=LeadIDElement.getText();
			System.out.println("Lead ID: "+LeadID);
//   12)Click First resulting lead
			LeadIDElement.click();
			Thread.sleep(2000);
//   13)Click Delete
			driver.findElement(By.linkText("Delete")).click();
//   14)Click Find Leads
			driver.findElement(By.linkText("Find Leads")).click();
//   15)Enter captured lead ID 
			driver.findElement(By.name("id")).sendKeys(LeadID);
//   16)Click find leads button
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			Thread.sleep(3000);
//   17)Verify message "No records to display" in the Lead List. This message confirms the successful deletion
			WebElement infoMessage=driver.findElement(By.className("x-paging-info"));
			System.out.println(infoMessage.getText());
			if(infoMessage.getText().contains("No records to display")) {
				System.out.println("The lead's record is deleted successfully and verified - Test Pass");
			}else {
				System.out.println("The deleted Lead's record is still visible-Test Fail");
			}
//   18)Close the browser
            driver.close();


		    
	}

}
