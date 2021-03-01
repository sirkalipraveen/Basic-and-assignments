package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("http://leaftaps.com/opentaps/control/main");
	    driver.manage().window().maximize();
	    String Title=driver.getTitle();
	    System.out.println(Title);
	    driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
	    driver.findElement(By.id("password")).sendKeys("crmsfa");
	    driver.findElement(By.className("decorativeSubmit")).click();
	    driver.findElementByPartialLinkText("CRM").click();
	    driver.findElement(By.linkText("Leads")).click();
	    driver.findElement(By.linkText("Find Leads")).click();
	    driver.findElement(By.linkText("Email")).click();
	    driver.findElement(By.xpath("((//input[@id='ext-gen282']))")).sendKeys("praveenilango@gmail.com");
	    Thread.sleep(30000);
	    driver.findElement(By.xpath("(//button[text()='Find Leads'])")).click();
	    Thread.sleep(20000);
	    WebElement LeadNameElement=driver.findElement(By.xpath("//a[text()='10323']"));
		String leadName=LeadNameElement.getText();
		System.out.println("Name of the first resulting lead is : "+leadName);
        LeadNameElement.click();
	    driver.findElement(By.linkText("Duplicate Lead")).click();
	    if(driver.getTitle().contains("Duplicate Lead")){
			System.out.println("Landed in Duplicate Lead page as expected- Test Pass");
		}else{
			System.out.println("Not Landed in Duplicate Lead page - Test Fail ");
		}
	   
	    driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
	    WebElement dupLeadNameElement=driver.findElement(By.xpath("(//span[contains(@id,'viewLead_firstName')])[1]"));
		String duplicatedLeadName=dupLeadNameElement.getText();
		System.out.println("Duplicated lead name:" +duplicatedLeadName);
		if(duplicatedLeadName.equalsIgnoreCase(leadName)) {
			System.out.println("Duplicated name is same as the captured name");
		}else {
			System.out.println("Duplicated name is not same as the captured name");
		}
	driver.close();
	}

}
