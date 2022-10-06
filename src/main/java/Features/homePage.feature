Feature: feature to search product in search bar functionality

  Scenario: Check products regarding the search are getting displayed or not

    Given user is on home page of Amazon website
    When user search the product in the search bar
    Then products are getting displayed which user searched for
    When I select "2" quantity from dropdown
    And I click on add to cart button and verify the quantity is "2"

