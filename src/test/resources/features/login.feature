Feature: Login

  Scenario: Login successfully
    Given the application is open
    When the user taps the Login button
    And the user enters valid credentials
    Then the user is logged in successfully