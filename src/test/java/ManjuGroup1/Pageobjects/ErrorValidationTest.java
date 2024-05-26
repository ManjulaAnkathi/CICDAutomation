package ManjuGroup1.Pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import ManjuGroup1.ManjuArtfact.CheckOut;
import ManjuGroup1.ManjuArtfact.cartPage;
import ManjuGroup1.ManjuArtfact.productCatalogue;
import ManjuGroup1.TestComponents.BaseTest;
import ManjuGroup1.TestComponents.Retry;

public class ErrorValidationTest extends BaseTest {

	@Test(retryAnalyzer= Retry.class)
	public  void LoginErrorValidation() throws IOException, InterruptedException
	{
		
		String Productname = "ZARA COAT 3" ;
		productCatalogue prodCatalogue = landingPage.loginApplication("Manjula@gmail.com","123");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrormessage());
		 
	}
	
	@Test
	public  void ProductErrorValidation() throws IOException, InterruptedException
	{
		
		String Productname = "ZARA COAT 3" ;
		productCatalogue prodCatalogue = landingPage.loginApplication("rahulshetty@gmail.com","Iamking@@000");
		List<WebElement>products = prodCatalogue.getProductList();
		
		  prodCatalogue.addProductToCart(Productname);
		  System.out.println("Gotocart");
		  cartPage cartPage = prodCatalogue.gotoCartpage(); 
		  boolean match = cartPage.viewCart("ZARA COAT 33" );
		  Assert.assertTrue(match);
			  
	}


}
