Feature: Login

  Scenario: Successful Login with Valid Credentials
    Given user Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "admin@yourstore.com" and User Enters Password as "admin"
    And click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on log out Link
    Then Page Title should be "Your store. Login"
    And close browser

  Scenario Outline: Login Data Driven
    Given user Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "<email>" and User Enters Password as "<password>"
    And click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on log out Link
    Then Page Title should be "Your store. Login"
    And close browser

    Examples:
    | email | password |
    | admin@yourstore.com | admin |
    | admin@yourstore.com | admin123 |
