Feature: Search

  Scenario: Search from home page
    Given the search field is visible
    When the user enters text in the search field
    Then the user is redirected to the search results page