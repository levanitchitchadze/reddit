Feature: Login

  Scenario: Login successfully
    Given the login page is open
    When the user enters valid credentials
    Then the user is logged in successfully