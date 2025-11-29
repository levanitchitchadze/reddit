Feature: Profile

  Scenario: Navigate to profile page
    Given the application is open
    And the user avatar is visible
    When the user taps the avatar
    And the user taps the "View Profile" button
    Then the user is redirected to the profile page