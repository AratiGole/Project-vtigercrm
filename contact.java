package vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;
@Listeners(ListenerImplementation.class)
public class contact {
	// create object of PropertyFileUtil class created in src/main/java in package commonUtils
	
		// create the object of all  util classes
		PropertyFileUtil putil= new PropertyFileUtil();
		WebDriverUtil wbUtil= new WebDriverUtil();
		ExcelUtil  exUtil= new ExcelUtil();
		JavaUtil jutil=new JavaUtil();

    @Test
	
	public void contactTest() throws IOException, InterruptedException {
		
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
		
		// to read data from Oraganization sheet
		String ORGNAME=exUtil.getDataFromExcel("organization",0,1);
		
		System.out.println(FirstName);
		System.out.println(LasttName);
		
		// To launch vtigercrm , pass the user name and password in login field
		driver.get(URL);
		//driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//To click on contact
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//To click on  Create contact...[!]--   + icon
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		//To create an contact enter field
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		driver.findElement(By.name("lastname")).sendKeys(LasttName);
		
		
		// To fail the Test script
		
		//WebElement notifycheckbox= driver.findElement(By.name("notify_owner"));
		//Assert.assertTrue()
		
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="http:Pune//localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
		Assert.assertEquals(actualUrl, expectedUrl);
		 //To click on AssignedTo click group radio button.
          driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
          
          // here test will fail and screnshot method will execuete to take screenshot at 124 line 
          
          
          
          //To select on drop down
          WebElement dropdown= driver.findElement(By.name("assigned_group_id"));
          wbUtil.handleWebDropDown(dropdown,GROUP);
          
          //Enter organization name (+) icon 
          driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
          
          //Transfer the control parent window to chld window tosearch searchfield
          wbUtil.switchWindow(driver,"http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
          
          //To search organization name in search field
          driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
          
          // To click on search button
         driver.findElement(By.name("search")).click();
          
          //Click on Oraganization name
         driver.findElement(By.xpath("//a[text()='Infosys pvt Ltd6']")).click();
         
         //To transfer control th echild window to parent window
         wbUtil.switchWindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
         
         //To click on save button
         driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
         
         Thread.sleep(3000);
         
         // Take screenshot of contact
         wbUtil.screenshot(driver,"contactScreenshot");
         
       //to mouse hover on img.

 		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

 		wbUtil.mouseHover(driver, img);

 		 

 		 //to click on Sign out.

 		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		
		

}
}
