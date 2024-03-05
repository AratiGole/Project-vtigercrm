 package vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;
@Test
public class Leads {
	
	// create object of PropertyFileUtil class created in src/main/java in package commonUtils
	
			// create the object of all  util classes
			PropertyFileUtil putil= new PropertyFileUtil();
			WebDriverUtil wbUtil= new WebDriverUtil();
			ExcelUtil  exUtil= new ExcelUtil();
			JavaUtil jutil=new JavaUtil();
			public void leadTest() throws IOException, InterruptedException {
				
				// To read data from property file
				WebDriver driver= new ChromeDriver();
				
				//to maximize window
				wbUtil.maximize(driver);
				
				// to apply wait for findElement()
				wbUtil.implisitWait(driver);
				String URL=putil.getDataFromPropertyFile("Url");
				String USERNAME=putil.getDataFromPropertyFile("Username");
				String PASSWORD=putil.getDataFromPropertyFile("Password");
				System.out.println(URL);
				System.out.println(USERNAME);
				System.out.println(PASSWORD);
				
				//to fetch data from excel file present in src/test/resource  with the help of
						//getDataFromExcel() of ExecelUtil class present in src/main/java/commonUtils .
						
				//To read data from Excel file organization ---sheet---contact
				String FirstName=exUtil.getDataFromExcel("contact",0,1);
				String LasttName=exUtil.getDataFromExcel("contact",1,1);
				String GROUP=exUtil.getDataFromExcel("contact",3,1);
				String OraganizationName= exUtil.getDataFromExcel("contact", 2, 1);
				System.out.println(GROUP);
				System.out.println(OraganizationName);
				
				System.out.println(FirstName);
				System.out.println(LasttName);
				
				// To launch vtigercrm , pass the user name and password in login field
				driver.get(URL);
				//driver.get("http://localhost:8888/");
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//To click on lead
				
				driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
				
				//To click on  Create contact...[!]--   + icon
				driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
				
				// To enter data in field
				driver.findElement(By.name("firstname")).sendKeys(FirstName);
				driver.findElement(By.name("lastname")).sendKeys(LasttName);
				driver.findElement(By.name("company")).sendKeys(OraganizationName);
				
				//to click on group radio button
				driver.findElement(By.xpath("//input[@name='assigntype'][2]")).click();
				
				//select dropdown 
				WebElement dropdown=driver.findElement(By.name("assigned_group_id"));
				wbUtil.handleWebDropDown(dropdown,GROUP);
				
				//To click on save button

				 driver.findElement(By.xpath("(//input[@name='button'])[1]")).click(); 

				 Thread.sleep(2000);

				 //to mouse hover on img.

				WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

				wbUtil.mouseHover(driver, img);

				 

				 //to click on Sign out.

				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

				
			
				
				
	
			}
}
