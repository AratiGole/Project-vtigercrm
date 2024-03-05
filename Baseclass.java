package commonUtils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Baseclass {
	
	public static WebDriver driver;
	
	WebDriverUtil wbUtil =new WebDriverUtil();
	PropertyFileUtil pUtil=new PropertyFileUtil();
	
	
	@BeforeSuite
	public void BS()
	{
		
	}
	@BeforeClass
	public void BC()
	{
		
	}
	
	@BeforeMethod
	public void BM()
	{
		
	}
	
	
	
	

	}
