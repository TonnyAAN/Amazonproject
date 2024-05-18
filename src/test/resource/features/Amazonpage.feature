Feature: Add socks to cart
  As a customer
  I want to add socks to my cart
  So that I can purchase them

  Background:
    Given I am on the Amazon UK homepage

  Scenario: Add to Amazon Cart

    When I click on the Sign in button
    And I enter a valid email or mobile number
    And I enter the correct password
    Then I should be signed in to my Amazon account
    When I search for "Socks"
    And I add the socks to the cart
    Then the socks should be in the cart