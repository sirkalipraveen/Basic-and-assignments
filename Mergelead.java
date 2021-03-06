package Week3day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Mergelead {

	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		// 1)Launch the browser 
		    ChromeDriver driver=new ChromeDriver();
		    driver.get("http://leaftaps.com/opentaps/control/main");
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(30000,TimeUnit.SECONDS);
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
		// 7)Click on Merge Lead
		    driver.findElement(By.linkText("Merge Leads")).click();
		// 8)Click on Icon near From Lead
		    driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		// 9) Move to new window
		    Set<String> allHandles=driver.getWindowHandles();
		    List<String> allHandlesList=new ArrayList<String>(allHandles);
			driver.switchTo().window(allHandlesList.get(1));
			driver.manage().window().maximize();
		// 10)Enter Lead ID
			driver.findElement(By.name("id")).sendKeys("10324");
			Thread.sleep(3000);
		// 11)Click Find Leads button
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		// 12)Click First Resulting lead
			driver.findElement(By.xpath("//a[text()='10324']")).click();
		// 13)Switch back to primary window
			driver.switchTo().window(allHandlesList.get(0));
			Thread.sleep(2000);
		// 14)Click on Icon near To Lead
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
			Thread.sleep(3000);
			Set<String> allHandles2=driver.getWindowHandles();
		    List<String> allHandlesList2=new ArrayList<String>(allHandles2);
			driver.switchTo().window(allHandlesList2.get(1));
			driver.manage().window().maximize();
		// 15)Move to new window
			driver.switchTo().window(allHandlesList2.get(1));
		// 16)Enter Lead ID
			driver.findElement(By.name("id")).sendKeys("10326");
		// 17)Click Find Leads button
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		// 18)Click First Resulting lead
			driver.findElement(By.xpath("//a[text()='10326']")).click();
		// 19)Switch back to primary window
			driver.switchTo().window(allHandlesList.get(0));
		// 20)Click Merge
			driver.findElement(By.xpath("//a[text()='Merge']")).click();
		// 21)Accept Alert
			driver.switchTo().alert().accept();
		// 22)Click Find Leads link
			driver.findElement(By.linkText("Find Leads")).click();
		// 23)Enter From Lead ID
			driver.findElement(By.name("id")).sendKeys("10326");
		// 24)Click Find Leads button
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        // 25)Verify message "No records to display" in the Lead List. This message confirms that the successful merge of leads
			WebElement check=driver.findElement(By.className("x-paging-info"));
			if(check.getText().equalsIgnoreCase("No records to display")) {
				System.out.println("No records to display - Lead info Merged successfully");
			}else {
				System.out.println("Lead info didn't merge successfully");
			}
        // 26)Close the browser (Do not log out)
			driver.quit();


			

			

			



			

		    

	}

}
