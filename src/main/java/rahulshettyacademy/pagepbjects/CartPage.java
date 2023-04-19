package rahulshettyacademy.pagepbjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;

import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='cartSection']/h3")
	List<WebElement> cart_pr;
	
	@FindBy(xpath = "//button[normalize-space()='Checkout']")
	WebElement checkOut_btn;
	
	
	public boolean checkProdListInCart(String prName) {		
		boolean result = cart_pr.stream().anyMatch(a -> a.getText().equalsIgnoreCase(prName));
		return result;
		//	driver.findElement(By.xpath("//button[normalize-space()=\"Checkout\"]")).click();
	}
	
	public void checkOut () {
		goToPage(checkOut_btn);
	} 

}
