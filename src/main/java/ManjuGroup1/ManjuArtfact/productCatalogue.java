package ManjuGroup1.ManjuArtfact;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Manju.AbstractComponents.Abstractcomponent;

public class productCatalogue extends Abstractcomponent{
	
	WebDriver driver;
	public productCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//PageFactory
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By productBy =By.cssSelector(".mb-3");
	By addToCart =By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productBy);
		return products;
	}
	
	public WebElement getProductByName(String Productname) {
		
		  WebElement prod = getProductList().stream().filter(product-> 
			product.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
			
		  return prod;
	}

	
	public void addProductToCart(String Productname) throws InterruptedException {
		
		WebElement prod = getProductByName(Productname);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
		
	}

}
