package Manju.AbstractComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ManjuGroup1.ManjuArtfact.CheckOut;

public class OrderPage extends Abstractcomponent {
	
	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//tbody/tr/td[2]")
	List<WebElement> Productlist;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle ;	
	
	public boolean viewOrder(String Productname) {
		 boolean match = Productlist.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(Productname));
		 return match;
		
	}
	
	
	
}
