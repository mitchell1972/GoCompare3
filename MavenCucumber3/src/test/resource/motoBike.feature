Feature: BDD for GoCompare: motorBike_Insurance 

@motorbike 
Scenario: Select Motorbike Insurance 
	Given I'm hovering over the Insurance menu 
	And the various insurance types are displayed 
	When I click on Motorbike Insurance 
	Then the Motorbike insurance page is displayed 
	Then close browser