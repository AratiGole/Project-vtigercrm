package commonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {

	public void maximize(WebDriver driver) {
	driver.manage().window().maximize();
	}
	
	public void implisitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void handleWebDropDown(WebElement element, String targetEleName)
	{
		Select s= new Select(element);
		s.selectByVisibleText(targetEleName);
		
		
	}
	
	public void mouseHover(WebDriver driver ,WebElement element)
	{
		Actions a= new Actions(driver);
		a.moveToElement(element);
		a.perform();
		
	}
	
	public void switchWindow(WebDriver driver, String expectedUrl) {
		Set<String> ids= driver.getWindowHandles();
		for(String e:ids) {
			String actualUrl= driver.switchTo().window(e).getCurrentUrl();
			if(actualUrl.contains(expectedUrl)) {
				break;
			}
			
			
		}
		
	}
	
	public File screenshot(WebDriver driver, String ScreenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File tempFile= ts.getScreenshotAs(OutputType.FILE);
		File destinationfile=new File("./Screenshot/"+ScreenshotName+".png");
		FileUtils.copyFile(tempFile,destinationfile);
		
		return destinationfile;
	}

}
