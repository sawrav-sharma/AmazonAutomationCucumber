Feature: feature to test login functionality

  Scenario: Check login is successful with valid credentials

    Given user is on sign in page of Amazon website
    When user enters mobileNumber "8529094816"
    Then user clicks on continue button
    And user enters password "Rupesh@123"
    Then clicks on Sign In Submit button and user is navigated to the home page and page contains "Hello, Rupesh"

