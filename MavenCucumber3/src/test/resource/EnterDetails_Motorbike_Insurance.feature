Feature: BDD for GoCompare: motorBike_Enter_Details 

@motorbikeEnterDetails 
Scenario: Select Get Quotes Button 
	Given I'm on the motorbike insurance comparison service page 
	And the FirstName, Surname, DateOfBirth and EmailAddress fields are displayed 
	When I enter the correct details 
	And click on the Continue button 
	Then the Personal details page for the name entered is displayed 
	Then close browser