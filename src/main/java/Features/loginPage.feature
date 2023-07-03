Feature: feature to test login functionality

  Scenario: Check login is successful with valid credentials

    Given user is on sign in page of Amazon website
    When user enters mobileNumber "your_number"
    Then user clicks on continue button
    And user enters password "your_password"
    Then clicks on Sign In Submit button and user is navigated to the home page and page contains "Hello, Rupesh"

