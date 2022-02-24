Feature: To validate Login ,Search ,Add to cart and Update Record Functionality.
#1
  @UI
  Scenario: Test to verify a user can create an account
   Given That the website home page is loaded on the web browser
    When a user clicks on login text at the top of the page
    And a user enters the following details
      | Email_Address           | Password |
      | remi.deji1000@yahoo.com | 1234567@ |
    And clicks the Signin button
    Then user account page should be loaded

#2

  Scenario: Test to verify a user cannot create an account using invalid Password
    Given That the website home page is up and running on the web browser
    When a user clicks on Signin text at the top of the page
    And a user Inputs the following details
      | Email_Address           | Password |
      | remi.deji1000@yahoo.com | 1234     |
    And clicks the Login button
    Then user account page should not be loaded
    And error message "There is 1 error" Invalid Password Should be displayed.

#3
  Scenario Outline: Test to Verify products can be searched for using the search functionality.
    Given that Website is loaded on the web browser.
    When a Customer inputs "<Search_Values>" in the search box
    And Clicks on Search or presses the enter button
    Then Products should be populated on the screen.
    Examples:
      | Search_Values         |
      | Dresses               |
      | Printed Summer Dress  |
      | Blouse                |
      | Printed Dress         |
      | Printed Chiffon Dress |
      | Summer Dresses        |

#4
  Scenario: Test to verify a product or products can be added to basket.
    Given That the website home page is loaded on the web browser
    When a Customer Enters "Dresses" in the search box.
    And click on search button
    And clicks on Add to cart button product from the lists of products on the screen
    Then Products should be successfully added to cart
    And  Success message "There is 1 item in your cart" is displayed.

