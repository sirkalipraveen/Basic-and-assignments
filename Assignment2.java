package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    // 1)Launch the browser 
    ChromeDriver driver=new ChromeDriver();
    driver.get("http://leaftaps.com/opentaps/control/main");
    driver.manage().window().maximize();
    // 2)Enter the username
    driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
    // 3)Enter the password
    driver.findElement(By.id("password")).sendKeys("crmsfa");
    // 4)Click  login
    driver.findElement(By.className("decorativeSubmit")).click();
    // 5)Click CRM/SFA link
    driver.findElementByPartialLinkText("CRM").click();
    // 6)Click Leads link
    driver.findElement(By.linkText("Leads")).click();
    // 7)Click Find Leads
    driver.findElement(By.linkText("Find Leads")).click();
    // 8)Enter name as Gopi
    driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='firstName']")).sendKeys("PRAVEEN");
    // 9)Enter Find button-Thread.sleep(
    Thread.sleep(2000);
    // 10)Click on first resulting lead - try this with table
    driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[text()='PRAVEEN']")).click();
    // 11)Verify title of the page
    String Title = driver.getCurrentUrl();
    System.out.println("Title of the page : "+ Title);
    // 12)Click Edit
    driver.findElement(By.linkText("Edit")).click();
    // 13)Change the company name - changing from New company to TestLeaf
    driver.findElement(By.xpath("//input[@value='CTS']")).clear();
	driver.findElement(By.xpath("//input[@value='CTS']")).sendKeys("RNAIPL");
    driver.findElement(By.xpath("//input[@value='CTS']")).click();
    // 14)Click Update
    driver.findElement(By.xpath("//input[@value='Update']")).click();
   // 15)Confirm the changed name appears
    WebElement check=driver.findElement(By.xpath("//span[contains(@id,'viewLead_companyName')]"));

	if(check.getText().contains("RNAIPL")) {
		System.out.println("Lead PRAVEEN's company name is changed to RNAIPL - Test Pass");
	}else {
		System.out.println("Lead PRAVEEN's company name is not changed to RNAIPL - Test Fail");
	}
	// 16)Close the browser
	  driver.close(); 
}}
