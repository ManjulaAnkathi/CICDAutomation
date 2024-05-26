package ManjuGroup1.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ManjuGroup1.ManjuArtfact.CheckOut;
import ManjuGroup1.ManjuArtfact.LandingPage;
import ManjuGroup1.ManjuArtfact.cartPage;
import ManjuGroup1.ManjuArtfact.productCatalogue;
import ManjuGroup1.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{
	
	public LandingPage landingpage;
	public productCatalogue prodCatalogue;
	public cartPage cartPage;
	public CheckOut checkOut;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landingpage = launchApplication();
	}
	
	@Given ("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username,String password)
	{
		prodCatalogue = landingPage.loginApplication(username,password);
		
	}
		@When ("^I add product (.+) to Cart$")
		public void I_add_product_to_cart(String productName) throws InterruptedException
		{
			List<WebElement>products = prodCatalogue.getProductList();
			  prodCatalogue.addProductToCart(productName);
		}
		
		@And ("^Checkout (.+) and submit the order$")
		public void checkout_and_submit_the_Order(String productName)
		{
			cartPage = prodCatalogue.gotoCartpage(); 
			boolean match = cartPage.viewCart(productName);
			Assert.assertTrue(match);
			 
			 checkOut = cartPage.ClicktoCheckout();
			 checkOut.proceedCheckout("India");
			 checkOut.ConfirmationPage();
			 
			 
		}
		
		@Then ("{string} message is displayed on ConfirmationPage")
		public void message_is_displayed_on_ConfirmationPage(String string)
		{
			String ordermessage = checkOut.getConfirmationMessage();
			String orderid = checkOut.getOrderID();
			 Assert.assertEquals(ordermessage,string);
			 System.out.printf(orderid);
			 driver.close();
		  
		}
		
	    @Then("^\"([^\"]*)\" message is displayed$")
	    public void message_is_displayed(String expectedErrorMessage) {
	    	Assert.assertEquals(expectedErrorMessage,landingPage.getErrormessage());
	    	driver.close();
			 
	    }

				
		
	}

