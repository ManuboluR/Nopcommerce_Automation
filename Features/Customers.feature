Feature:Customers
  Background: Below are the common steps for each scenario
    Given user Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "admin@yourstore.com" and User Enters Password as "admin"
    And click on Login
    Then user can view Dashboard
  Scenario: Add a new customer
    When User click on customer menu
    And click on customer menu Item
    And click on Add new button
    Then user can view add new customer page
    When user enter customer info
    And click on save button
    Then User can view  confirmation message "The new customer has been added succssfully."
    And close browser
  Scenario: Search Customer By EmailId
    When User click on customer menu
    And click on customer menu Item
    And Enter Customer EmailID
    When Click on Search button
    Then User should found email in the search table
    And close browser
