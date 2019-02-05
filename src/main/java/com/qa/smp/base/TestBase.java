package com.qa.smp.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.smp.util.*;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	@BeforeTest
	public void init() {
		// Read Properties file
		try {
			prop = new Properties();
			FileInputStream fi;
			fi = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SMProject\\src\\main\\java\\com\\qa\\smp\\config\\Config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Browser Initialization
		String browser = prop.getProperty("Browser");
		if (browser.equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "D:\\\\Krishnendu\\\\Selenium\\\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "E:\\\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("IE")) {
//			WebDriverManager.iedriver().setup();
//			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
		
}
