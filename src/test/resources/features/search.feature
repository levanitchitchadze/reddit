Feature: Search

  Scenario: Use search field
    Given the search field is visible
    When the user enters text in the search field
    Then the user is redirected to the search results page