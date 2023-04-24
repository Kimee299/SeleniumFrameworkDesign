package rahulshettyacademy.pagepbjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class MyOdersPage extends AbstractComponent{
	WebDriver driver;

	public MyOdersPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "tbody tr:last-of-type th")
	WebElement lastOrderIDofList;
	
//	@FindBy(css = "tbody tr:last-of-type th")
//	WebElement lastOrderIDofList;
	
	
	public String getLastOrderID() {
		return lastOrderIDofList.getText();
	}
}
