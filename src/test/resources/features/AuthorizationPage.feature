Feature: As a user I want to log in to my account

  @test
  Scenario: Guest entered incorrect login information and redirected to separate page with an error notification
    Given user opens Home Page
    And user clicks on Sign in or Join button in Navigation Bar
    And guest enters incorrect data in the Email and Password fields
    When guest confirms entered data
    Then guest redirected to separate Sign In page with an error notification