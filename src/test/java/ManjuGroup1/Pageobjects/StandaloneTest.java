package ManjuGroup1.Pageobjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Manju.AbstractComponents.OrderPage;
import ManjuGroup1.ManjuArtfact.CheckOut;
import ManjuGroup1.ManjuArtfact.LandingPage;
import ManjuGroup1.ManjuArtfact.cartPage;
import ManjuGroup1.ManjuArtfact.productCatalogue;
import ManjuGroup1.TestComponents.BaseTest;

public class StandaloneTest extends BaseTest {
	
	String Productname = "ZARA COAT 3" ;

	@Test(dataProvider="getData")
	public  void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
		
		
		productCatalogue prodCatalogue = landingPage.loginApplication(input.get("email"),input.get("pw"));
		List<WebElement>products = prodCatalogue.getProductList();
		
		  prodCatalogue.addProductToCart(input.get("product"));
		  System.out.println("Gotocart");
		  cartPage cartPage = prodCatalogue.gotoCartpage(); 
		  boolean match = cartPage.viewCart(input.get("product"));
		  Assert.assertTrue(match);
		 
		 CheckOut checkOut = cartPage.ClicktoCheckout();
		 checkOut.proceedCheckout(input.get("country"));
		 checkOut.ConfirmationPage();
		 String ordermessage = checkOut.getConfirmationMessage();
		 String orderid = checkOut.getOrderID();
		 
		 Assert.assertEquals(ordermessage,"THANKYOU FOR THE ORDER.");
		 System.out.printf(orderid);
	  
	}
	@Test(dependsOnMethods= {"SubmitOrder"})
	 public void OrderHistoryTest() {
		 productCatalogue prodCatalogue = landingPage.loginApplication("Manjula@gmail.com","Manju123");
		 
		OrderPage orderPage = prodCatalogue.gotoOrderpage();
		Assert.assertTrue(orderPage.viewOrder(Productname));
	 }

	
	@DataProvider
	public Object[][] getData() throws IOException {
		
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "Manjula@gmail.com");
//		map.put("pw","Manju123");
//		map.put("country", "India");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "Navina@gmail.com");
//		map1.put("pw","Manju1234");
//		map1.put("country", "India");
//		map1.put("product", "ADIDAS ORIGINAL");
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//ManjuGroup1//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
}
