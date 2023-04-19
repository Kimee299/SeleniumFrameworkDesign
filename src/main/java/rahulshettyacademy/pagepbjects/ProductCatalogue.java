package rahulshettyacademy.pagepbjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	// Constructor
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// pageFactory
	@FindBy(css = ".mb-3")
	List<WebElement> prods;
	
	@FindBy(css = ".ng-animating")
	WebElement animating;
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;
	@FindBy(css = "#toast-container")
	WebElement toast;
	@FindBy(css = ".mb-3")
	WebElement productsBy;

//	By productsBy = By.cssSelector(".mb-3");
//	By toast = By.cssSelector("#toast-container");
//	By animating = By.cssSelector(".ng-animating");
//	By cart = By.cssSelector("[routerlink*='cart']");
	
	public List<WebElement> getProductList() {
		//explicit wait
		waitForElToAppear(productsBy);
		return prods;
	}
	
	public WebElement getProdByName (String prName) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(prName)).findFirst()
				.orElse(null);
		return prod;
	}
	
	public void addToCart(WebElement prod) {
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
	}
	
	public void openCart() {
		waitForElToAppear(toast);
		waitForElToLoaded(animating);
		goToPage(cart);
	}

	
	// click all button add-to-cart
//	driver.findElements(By.xpath("//button[text()=' Add To Cart']")).forEach(a -> {
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		a.click();});

}
