package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2day1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
	    driver.findElement(By.linkText("Create Lead")).click();
		
	   WebElement source=driver.findElement(By.id("createLeadForm_dataSourceId"));
	    WebElement source1=driver.findElement(By.id("createLeadForm_marketingCampaignId"));
	   Select dropdown=new Select(source); 
	   Select dropdown1= new Select(source1);
	   //dropdown.selectByVisibleText("Employee");
	   // dropdown1.selectByVisibleText("Car and Driver");
	  //dropdown.selectByValue("LEAD_CONFERENCE"); 
	   //dropdown1.selectByValue("DEMO_MKTG_CAMP"); 
	   dropdown.selectByIndex(2);
	    dropdown1.selectByIndex(8);
	    
	    /*driver.findElement(By.id("createLeadForm_CompanyName")).sendKeys("RNAIPL");
		driver.findElement(By.id("createLeadForm_FirstName")).sendKeys("Praveen");
		driver.findElement(By.id("createLeadForm_LastName")).sendKeys("I");
		driver.findElement(By.name("submitButton")).click();
		System.out.println(driver.getTitle());
		*/

	}

}
