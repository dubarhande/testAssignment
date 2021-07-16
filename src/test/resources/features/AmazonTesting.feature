Feature: Test Amazon book price.

  Scenario: Validate Amazon book price at 3 steps.
    Given I navigate to url
    When I search for books "qa testing for beginners", match price and click on item number 1 from grid
    Then I match price after click
    When I click on add to cart
    Then I math price in cart
    When I click on proceed to checkout
#    Next step works only after log in into account. I have designed next step after logging in but removed my credentials so it won't work and removed assert from next step too.
    Then I match price on checkout


