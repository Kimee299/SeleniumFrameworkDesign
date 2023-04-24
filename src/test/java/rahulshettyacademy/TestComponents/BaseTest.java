package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pagepbjects.LandingPage;

import org.testng.annotations.*;
//import org.testng.annotations.AfterMethod;

public class BaseTest {
	
	public WebDriver driver;
	Properties prop = new Properties();
	String fileValue = System.getProperty("user.dir")+
			"\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties";
	
	public WebDriver initializeDriver() throws IOException {
		//properties class
		FileInputStream file = new FileInputStream(fileValue);
		prop.load(file);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions options = new FirefoxOptions();
//			options.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod (alwaysRun = true)
	public LandingPage launchApp() throws IOException{
		FileInputStream file = new FileInputStream(fileValue);
		prop.load(file);
		driver = initializeDriver();
		String url = prop.getProperty("url");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo(url);
		return landingPage;
	}
	
//	@AfterMethod (alwaysRun = true)
//	public void tearDown() {
//		driver.close();
//	}
	
}
