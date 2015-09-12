Feature: BDD for GoCompare: motorBike_Quotes

  @motorbikeQuotes
  Scenario: Select Get Quotes Button
    Given I'm on the motorbike Insurance Page
    And the Get Quotes button is visible
    When I click on the Get Quotes Button
    Then the start a new quote page is displayed
