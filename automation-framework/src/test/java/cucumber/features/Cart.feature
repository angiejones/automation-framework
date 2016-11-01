Feature: Manage Cart
  As a user, I want to manage my cart so that I am buying the right things

Scenario: Increase quantity
Given product Apple TV is in the cart
When I update its quantity to 3
Then its price should be $80.00
And its total should be $240.00