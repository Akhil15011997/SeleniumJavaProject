package ConfigFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import Test.Config_Test1_GoogleSearch2;

public class PropertiesFile {
	public static void main(String[] args) {
		getProperties(); // setProperties();
	}
	static Properties prop = new Properties();
	static String ProjectPath = System.getProperty("user.dir");
	public static void getProperties() {
		try {
			InputStream input = new FileInputStream(ProjectPath+"/src/test/java/ConfigFiles/Config.properties");
			prop.load(input); String browser = prop.getProperty("browser");
			 System.out.println(browser);
			Config_Test1_GoogleSearch2.BrowserName = browser;
		} catch (Exception e) {
			System.out.println(e.getMessage()+ "\n" + e.getCause()); 
			e.printStackTrace();
		}
	}
	public static void setProperties() {
		try {
			OutputStream output = new FileOutputStream(ProjectPath+"/src/test/java/ConfigFiles/Config.properties");
			prop.setProperty("browser", "chrome");
			prop.store(output, null);  
		} catch (Exception e) {
			System.out.println(e.getMessage()+ "\n" + e.getCause()); 
			e.printStackTrace();
		}
		
	}

}
