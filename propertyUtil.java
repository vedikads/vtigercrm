package CommanUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyUtil {

	public String getDataFromPropertyFile(String key) throws IOException {
		
		//fileOutputStream is use to give the data in external file. & FileInputStream is useto read the data from external file.
	    //Steps:
		
		//Step1: Create the Object of FileInputStream class.in FileInputStream constructor we have to pass the agrument in the form of string that is path of the external file.
		FileInputStream fis = new FileInputStream("src\\test\\resources\\logincredentials.properties");
		
		//Step2:Create the Object of Properties class.and import from java.utilpackage
		Properties p = new Properties();
		
		//Step3: Call load( inputstream) to fetch the location of external file.it will throw u  inputoutput exception add throws
		p.load(fis);
		
		String value = p.getProperty(key);
	
		return value;
		
	}

}
