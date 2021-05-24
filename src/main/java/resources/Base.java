package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public Properties prop;
	public WebDriver driver;
	
	public WebDriver invokeDriver() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\sushi\\Selenium Project\\E2ECommerce\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
		
		String browsername = prop.getProperty("browser");
		//String urlink = System.getProperty("url");
		
		if(browsername.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sushi\\Selenium Project\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.contains("IE"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\firefoxdriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browsername.contains("firefox"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\Workspac\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
				
	}

	public String getScreenshot(String testcasename, WebDriver driver) throws IOException
	{
		TakesScreenshot ts  = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinatonfile = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		FileUtils.copyFile(source,new File(destinatonfile));
		return destinatonfile;
	}
	
	
}
