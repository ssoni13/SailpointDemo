package sushilecommerce.E2ECommerce;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobject.Cart;
import pageobject.LoginPage;
import pageobject.WomenShopping;
import resources.Base;

public class SignTest extends Base {
	
	public WebDriver driver;
	
	@Test
	public void signin() throws IOException, InterruptedException
	{
		System.out.println("Test case 1 start");
		driver = invokeDriver();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.username().sendKeys("vidyut.test@gmail.com");
		lp.password().sendKeys("kalyan@1234");
		lp.submit().click();
		WomenShopping ws = new WomenShopping(driver);	
		Actions a = new Actions(driver);
		a.moveToElement(ws.searchWomenOver()).perform();
		ws.searchTshirt().click();
		a.moveToElement(ws.product()).perform();	
		ws.addtoCart().click();
		Thread.sleep(3000);
		ws.proceed().click();
		Cart c = new Cart(driver);
		String title= c.getTitle().getText();
		Assert.assertEquals(title, "1 Product");
		System.out.println("Test case 1 End");
	}
}
