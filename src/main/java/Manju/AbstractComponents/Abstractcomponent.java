package Manju.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ManjuGroup1.ManjuArtfact.cartPage;

public class Abstractcomponent {
	
	WebDriver driver;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	@FindBy(css="[routerlink*='myorders']")
	WebElement Order;
	
	
	public Abstractcomponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public cartPage gotoCartpage() {
		cart.click();
		cartPage cartPage = new cartPage(driver);
		return cartPage;
		
	}
	public OrderPage gotoOrderpage() {
		Order.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
		
	}

	public void waitForElementToAppear(By findBy) {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
		}
		
	
	public void waitForElementToDisappear(WebElement Ele) throws InterruptedException {
		Thread.sleep(2000);
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(Ele));
		
	}

}
