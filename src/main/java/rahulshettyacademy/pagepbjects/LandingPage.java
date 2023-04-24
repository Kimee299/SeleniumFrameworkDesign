package rahulshettyacademy.pagepbjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;

	// Constructor
	public LandingPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	WebElement mail = driver.findElement(By.id("userEmail"));
//	WebElement pw = driver.findElement(By.id("userPassword"));

	// pageFactory
	@FindBy(id = "userEmail")
	WebElement mail;
	@FindBy(id = "userPassword")
	WebElement pw;
	@FindBy(id = "login")
	WebElement loginbtn;
	@FindBy(id = "toast-container")
	WebElement toast;

	public void loginApp(String email, String userpw) {
		mail.sendKeys(email);
		pw.sendKeys(userpw);
		loginbtn.click();
	}
	
	public void goTo(String url){
		driver.get(url);
	}
	
	public String getToast() {
		waitForElToAppear(toast);
		return toast.getText();
	}
}
