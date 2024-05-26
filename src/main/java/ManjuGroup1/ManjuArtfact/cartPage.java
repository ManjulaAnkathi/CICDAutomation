package ManjuGroup1.ManjuArtfact;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Manju.AbstractComponents.Abstractcomponent;

public class cartPage extends Abstractcomponent {
	
	WebDriver driver;
	public cartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProduct;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle ;	
	
	public boolean viewCart(String Productname) {
		 boolean match = cartProduct.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(Productname));
		 return match;
		
	}
	
	public CheckOut ClicktoCheckout() {
		checkoutEle.click();
		CheckOut checkOut= new CheckOut(driver);
		return checkOut;
		
	}
	
}
