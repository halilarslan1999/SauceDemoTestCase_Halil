Feature: Login and E"E Test

  @wip
  Scenario: Login and End to End Test

    Given The user is on the login page
    When The user enters username "standard_user" and password "secret_sauce"
    Then The user should be able to login and see "PRODUCTS" header
    And The user should be able to sort the products "Price (high to low)"
    Then The user clicks cheapest as "7.99" and second "29.99" cost list product
    And The user opens the basket
    Then The user clicks checkout
    And The user enters "John" , "Snow" and "48496"
    Then User clicks continue button
    And The user verifies that items are"41.02" and be able to see total is "Total: $41.02"
    Then The user should finalize the purchase
    And Purchase will be confirmed
