@tag
Feature: Purchase the order from Ecommerce website

	Background:
	Given I landed on Ecommerce page
	
	@tag2
	Scenario Outline: Positive Test of Submitting Order
	
	Given Logged in with username <name> and password <password>
	When I add product <productName> to Cart
	And Checkout <productName> and submit the order
	Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
	
	Examples:
	|name             | password |productName|
	|manjula@gmail.com| Manju123  |ZARA COAT 3|
	