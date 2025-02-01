#@smoke
#Feature: Store E2E Scenario to check Store Website Functionality
#  Scenario: Validate user could be able to do normal checkout process and confirm order
#
#    Given user login with valid "elliot.kuphal@hotmail.com" and "P@ssw0rd"
#    When user click on login button
#    And user Click on MP3 Players then Show all MP3 Players
#    And user Add "ipod shuffle" to the cart
#    Then Info message Success: You have added ipod shuffle to your shopping cart!
#    And user Open shopping cart
#    Then user check on the item added & it's price
#    And user Click on View Cart
#    And user Click on Checkout button
#    And user Fill billing details by new address
#    And user Check on Address drop down filled by new address
#    And user Click on continue button
#    And user click on continue button
#    And user Add Comment
#    And user Click on Continue button
#    And user check on Terms & conditions
#    And user Click on Continue button
#    Then Confirm order section will appear with the same prices as in shopping cart
#    And Total price includes the Flat shipping rate
#    And user Click on Confirm Order button
#    Then Your order has been placed! message displayed
#    And zero items found in the small Shopping cart
#    And user Log out successfully