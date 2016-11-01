Feature: Search for Products
  As a user, I want to search the catalog so that I can find specific products

Scenario: Click search result
  Given there is a product named Apple TV
  And I search for the product
  When I click the product
  Then I should be taken to the product page
  
Scenario: Add product from search result to cart
  Given there is a product named Apple TV
  When I search for the product
  And I add the product to the cart
  Then the product should be in the cart