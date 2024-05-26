package ManjuGroup1.ManjuArtfact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Manju.AbstractComponents.Abstractcomponent;

public class CheckOut extends Abstractcomponent {
	
	
	WebDriver driver;
	public CheckOut(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectcountry;
	
	@FindBy(css=".actions a")
	WebElement placeorder;
	
	@FindBy(xpath="//tbody/tr/td/h1")
	WebElement ordermessage;
	
	@FindBy(xpath="//label[contains(@class,'ng-star-inserted')]")
	WebElement orderid;
	
	
	By countryname =By.cssSelector(".ta-results");
	
	public void proceedCheckout(String cntry) {
		
		country.sendKeys(cntry);
		waitForElementToAppear(countryname);
		selectcountry.click();
		
		
	}
	
	public void ConfirmationPage() {
		placeorder.click();
		
	}
	
	public String getConfirmationMessage() {
		
		String orderMessage = ordermessage.getText();
		return orderMessage;
	}
	
	public String getOrderID() {
		
		 return orderid.getText();
		
	}
	
	
	
	
	

}
