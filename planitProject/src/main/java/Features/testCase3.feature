Feature: Go to cart page and purchase something
  Scenario: Calculate the total in the cart page.

    Given The Planit Home Page
    When Go to the Shop page
    Then Add Products into Cart
    Then Verify the subtotal of each product
    Then Verify price for each product
    And verify the Amount
    And Close the browser
