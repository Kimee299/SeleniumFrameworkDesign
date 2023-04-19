package rahulshettyacademy.pagepbjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder=\"Select Country\"]")
	WebElement country;
	@FindBy(xpath = "(//span[@class='ng-star-inserted'])[1]")
	WebElement country_span;

	@FindBy(xpath = "//input[@value='4542 9931 9292 2293']")
	WebElement cardNo;

	@FindBy(xpath = "//div[@class='payment__cc']//div[2]//input[1]")
	WebElement cvv;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement cardName;

//	@FindBy (xpath="(//select[@class='input ddl'])[1]")
//	WebElement cardYear;

	@FindBy(xpath = "//a[normalize-space()='Place Order']")
	WebElement order_btn;
	
	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']")
	WebElement countrySugessOpt;

//	WebElement cardYear = driver.findElement(By.xpath("//select[@class='input ddl'])[1]"));
//	WebElement cardDate = cardYear.findElement(RelativeLocator.with(By.tagName("select")).near(cardYear));
//	public WebElement getCardDate() {
//		return driver.findElement(RelativeLocator.with(By.tagName("select")).near(cardYear));
//	}

	// input info in order page
	public void inputInfo(WebElement year, WebElement date) {
		country.sendKeys("Vi");
		waitForElToAppear(country);
//		getCountrySuggession();
		country_span.click();
		cardNo.clear();
		cardNo.sendKeys("1234 5678 12345 5678");
		Select optYear = new Select(year);
		optYear.selectByVisibleText("12");

		Select optDate = new Select(date);
		optDate.selectByVisibleText("31");
		cvv.sendKeys("242");
		cardName.sendKeys("test name");

	}

	public void sumitOrder() {
		waitToClickable(order_btn);
		goToPage(order_btn);
	}

	public void getCountrySuggession() {
		List<WebElement> opts = driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button"));
		for (WebElement el : opts) {
//			System.out.println(el.getText());
			if(el.getText().equalsIgnoreCase("Latvia")) {
				el.click();
				break;
			}
		}
		return;
	}
}
