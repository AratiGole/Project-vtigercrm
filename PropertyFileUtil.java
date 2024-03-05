package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyFileUtil {

	public String getDataFromPropertyFile(String keyName) throws IOException
	{
		//fileInpuStream is use to give the data in external , & FileIputstram is use to the data from external file.
 		
		// step 1-: Create the Object of FileInputStream constructor we have to pass the argument as a path of property file
 		
		FileInputStream fis= new FileInputStream("src\\test\\resources\\login_Credential.properties");
		
		// step 2: Create the Object of Properties class and import from java.util package.
 		Properties p= new Properties();
 		
 		//step 3: call load (inputstream) to fetch the location of external 
		p.load(fis);
		String value=p.getProperty(keyName);
		return value;
	}
}
