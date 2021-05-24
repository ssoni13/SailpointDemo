package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	
	public WebDriver driver;
	
	public Cart(WebDriver driver)
	{
		this.driver =driver;
	}
	
	By title = By.id("summary_products_quantity");
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}

}
