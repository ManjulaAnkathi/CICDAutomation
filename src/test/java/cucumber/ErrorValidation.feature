@tag
Feature: Error Validation

	@ErrorValidation
	Scenario Outline: Negative Test of Submitting Order
	Given I landed on Ecommerce page
	When Logged in with username <name> and password <password>
	Then "Incorrect email or password." message is displayed
	
	Examples:
	|name             | password |
	|manjula@gmail.com| Manju12  |
	