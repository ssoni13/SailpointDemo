package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WomenShopping {
	
	public WebDriver driver;
	
	public WomenShopping(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By searchwomen = By.xpath("//div[@id='block_top_menu']/ul/li[1]");
	By tshirt = By.xpath("//a[@title='T-shirts']");
	By product = By.xpath("//a[@class='product_img_link']");
	By cart = By.xpath("//a[@title='Add to cart']");
	By proceed = By.xpath("//a[@title='Proceed to checkout']");
	
	public WebElement searchWomenOver()
	{
		WebElement target = driver.findElement(searchwomen);
		return target;
	}
	
	public WebElement searchTshirt()
	{
		return driver.findElement(tshirt);
	
	}
	
	public WebElement product()
	{
		WebElement tar = driver.findElement(searchwomen);
		return tar;
	}
	
	public WebElement addtoCart()
	{
		return driver.findElement(cart);
	}
	
	public WebElement proceed()
	{
		return driver.findElement(proceed);
	}	

}
