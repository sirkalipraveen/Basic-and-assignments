package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
//1	 Launch the browser
		ChromeDriver driver=new ChromeDriver();
	    driver.get("http://leaftaps.com/opentaps/control/main");
	    driver.manage().window().maximize();
	    String Title=driver.getTitle();
	    System.out.println(Title);
//2	 Enter the username
	    driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
//3	 Enter the password
	    driver.findElement(By.id("password")).sendKeys("crmsfa");
//4	 Click Login
	    driver.findElement(By.className("decorativeSubmit")).click();
//5	 Click crm/sfa link
	    driver.findElementByPartialLinkText("CRM").click();
//6	 Click Leads link
	    driver.findElement(By.linkText("Leads")).click();
//7	 Click Find leads
	    driver.findElement(By.linkText("Find Leads")).click();
//8	 Click on Email
	    driver.findElement(By.linkText("Email")).click();
//9	 Enter Email
	    driver.findElement(By.xpath("((//input[@id='ext-gen282']))")).sendKeys("praveenilango@gmail.com");
//10 Click find leads button
	    driver.findElement(By.xpath("(//button[text()='Find Leads'])")).click();
	    Thread.sleep(20000);
//11 Capture name of First Resulting lead
	    WebElement LeadNameElement=driver.findElement(By.xpath("//a[text()='10323']"));
		String leadName=LeadNameElement.getText();
		System.out.println("Name of the first resulting lead is : "+leadName);
//12 Click First Resulting lead	
        LeadNameElement.click();
//13 Click Duplicate Lead 
        driver.findElement(By.linkText("Duplicate Lead")).click();
//14 Verify the title as 'Duplicate Lead'	    
        if(driver.getTitle().contains("Duplicate Lead")){
			System.out.println("Landed in Duplicate Lead page as expected- Test Pass");
		}else{
			System.out.println("Not Landed in Duplicate Lead page - Test Fail ");
		}
//15 Click Create Lead  
	    driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
//16 Confirm the duplicated lead name is same as captured name 
	    WebElement dupLeadNameElement=driver.findElement(By.xpath("(//span[contains(@id,'viewLead_firstName')])[1]"));
		String duplicatedLeadName=dupLeadNameElement.getText();
		System.out.println("Duplicated lead name:" +duplicatedLeadName);
		if(duplicatedLeadName.equalsIgnoreCase(leadName)) {
			System.out.println("Duplicated name is same as the captured name");
		}else {
			System.out.println("Duplicated name is not same as the captured name");
		}
//17 Close the browser (Do not log out)
	driver.close();
	}

}
