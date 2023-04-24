package rahulshettyacademy.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pagepbjects.CartPage;
import rahulshettyacademy.pagepbjects.LandingPage;
import rahulshettyacademy.pagepbjects.OrderPage;
import rahulshettyacademy.pagepbjects.ProductCatalogue;

public class ErrorValidations extends BaseTest {

	@Test(dependsOnMethods = { "loginSite" })
	public void loginAgain() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApp("testting1kp@gmail.com", "@Az1234567");
		Assert.assertEquals(landingPage.getToast(), "Login Successfully");
	}

	@Test
	public void loginSite() throws IOException {
		String buy_pr = "ADIDAS ORIGINAL";

		// login step
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApp("testting1kp@gmail.com", "@Az1234568");
		// Incorrect email or password.
		// Login Successfully
		Assert.assertEquals(landingPage.getToast(), "Incorrect email or password.");
	}

}