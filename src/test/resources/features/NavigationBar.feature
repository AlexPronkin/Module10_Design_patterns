Feature: As a user I want to get ability to use Navigation Bar sections

  @test
  Scenario: Sign in/Join button in Navigation Bar should open login page
    Given user opens Home Page
    When user clicks on Sign in or Join button in Navigation Bar
    Then current URL contains "login" word

  @test
  Scenario: Order Status button in Navigation Bar should open Search Order page
    Given user opens Home Page
    When user clicks on Order Status button in Navigation Bar
    Then current URL contains "track" word

  @test
  Scenario: Unauthorised user clicked Wishlist button will be redirected to Sign in/Join page
    Given user opens Home Page
    When user clicks on Wishlist button in Navigation Bar
    Then current URL contains "login" word