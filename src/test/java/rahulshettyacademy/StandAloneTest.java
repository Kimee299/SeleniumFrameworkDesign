package rahulshettyacademy;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pagepbjects.CartPage;
import rahulshettyacademy.pagepbjects.LandingPage;
import rahulshettyacademy.pagepbjects.OrderPage;
import rahulshettyacademy.pagepbjects.ProductCatalogue;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
//		ChromeDriver driver = new ChromeDriver(options);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();

		// login step
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApp("testting1kp@gmail.com", "@Az1234567");

		String buy_pr = "ADIDAS ORIGINAL";
		
		// get list all products
		ProductCatalogue listprod = new ProductCatalogue(driver);
		WebElement prod = listprod.getProdByName(buy_pr);
		
		//add to cart
		listprod.addToCart(prod);
		
		//open cart
		listprod.openCart();
		
		//click checkout
		CartPage cartPage = new CartPage(driver);
		if(cartPage.checkProdListInCart(buy_pr)) {
			cartPage.checkOut();					
		}else{
			System.out.println("selected item is wrong!");
		};
		
		//input info in order page
		WebElement cardYear = driver.findElement(By.xpath("(//select[@class='input ddl'])[1]"));
		WebElement cardDate = driver.findElement(RelativeLocator.with(By.tagName("select")).near(cardYear));
		OrderPage orderPage = new OrderPage(driver);
		orderPage.inputInfo(cardYear,cardDate);
		
		//submit order
		//add commit
		orderPage.sumitOrder();
		
//		driver.close();
	}

}
