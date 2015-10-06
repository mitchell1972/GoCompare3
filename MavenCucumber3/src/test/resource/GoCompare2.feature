Feature: BDD for GoCompare: Car_Insurance 

@car 
Scenario: Select Car Insurance 
	Given I'm hovering over the Insurance menu 
	And the various insurance types are displayed 
	When I click on Car Insurance 
	Then the Car insurance page is displayed 
	Then close browser 
