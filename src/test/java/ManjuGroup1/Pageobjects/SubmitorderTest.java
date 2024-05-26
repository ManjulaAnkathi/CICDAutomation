package ManjuGroup1.Pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ManjuGroup1.ManjuArtfact.LandingPage;

public class SubmitorderTest {

	public static void main(String[] args) {
		
		String Productname = "ZARA COAT 3" ;
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		driver.get("https://rahulshettyacademy.com/client");
		
		LandingPage landingPage = new LandingPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("Manjula@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Manju123");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	WebElement prod = products.stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']")));
		
		System.out.println("Go to cart");
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		 boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(Productname));

		 Assert.assertTrue(match);
		 
		 driver.findElement(By.cssSelector(".totalRow button")).click();
		 
		 driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("india");
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		 driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();//XPATH(//button[contains(@class,'ta-item')])[2]
		  
		 
		 driver.findElement(By.cssSelector(".actions a")).click();
		 
		 Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr/td/h1")).getText(),"THANKYOU FOR THE ORDER.");
		 
		  String orderid1 = driver.findElement(By.xpath("//label[contains(@class,'ng-star-inserted')]")).getText();
		  
		 // String orderid2 = driver.findElement(By.xpath("//tbody/tr/td/label[1]")).getText();
		 
		 System.out.printf(orderid1);
		 
		 driver.close();
		 
	}

}
