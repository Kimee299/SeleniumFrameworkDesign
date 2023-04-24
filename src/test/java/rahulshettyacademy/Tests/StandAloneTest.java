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
import rahulshettyacademy.pagepbjects.MyOdersPage;
import rahulshettyacademy.pagepbjects.OrderPage;
import rahulshettyacademy.pagepbjects.ProductCatalogue;

public class StandAloneTest extends BaseTest {

	@Test
	public void sumitOrder() throws IOException {
		String buy_pr = "ADIDAS ORIGINAL";
		String URL = "https://rahulshettyacademy.com/client";
		// launch page
//		launchApp();

		// login step
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApp("testting1kp@gmail.com", "@Az1234567");

		// get list all products
		ProductCatalogue listprod = new ProductCatalogue(driver);
		WebElement prod = listprod.getProdByName(buy_pr);

		// add to cart
		listprod.addToCart(prod);

		// open cart
		listprod.openCart();

		// click checkout
		CartPage cartPage = new CartPage(driver);
		if (cartPage.checkProdListInCart(buy_pr)) {
			cartPage.checkOut();
		} else {
			System.out.println("selected item is wrong!");
		}
		;

		// input info in order page
		WebElement cardYear = driver.findElement(By.xpath("(//select[@class='input ddl'])[1]"));
		WebElement cardDate = driver.findElement(RelativeLocator.with(By.tagName("select")).near(cardYear));
		OrderPage orderPage = new OrderPage(driver);
		orderPage.inputInfo(cardYear, cardDate);

		// submit order
		orderPage.sumitOrder();
		
		//validate checkout success
		orderPage.checkoutSucess();
		String orderID = orderPage.getOrderID();
		System.out.println(orderID);
		//open history page
		orderPage.openHistoryPage();
		
		//open MyOrders page
		MyOdersPage myOrder = new MyOdersPage(driver);
		Assert.assertEquals(myOrder.getLastOrderID(),orderID);
		
		
	}
	
}