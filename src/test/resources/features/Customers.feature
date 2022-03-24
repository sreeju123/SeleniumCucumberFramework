Feature: Customers Page Scenarios

  Scenario: Validate Invalid Email
    Given The admin navigates to "https://admin-demo.nopcommerce.com/login?returnurl=%2Fadmin%2F"
    And The admin clears the email
    And Clicks Submit button
    Then The Invalid email error should be displayed

  Scenario: Sample Validate Invalid Email
    Given The admin navigates to "https://admin-demo.nopcommerce.com/login?returnurl=%2Fadmin%2F"
    And The admin clears the email
    And Clicks Submit button
    Then The Invalid email error should be displayed

  Scenario: Add new customer details to nopCommerce admin Application
    Given The admin navigates to "https://admin-demo.nopcommerce.com/login?returnurl=%2Fadmin%2F"
    And Clicks Submit button
    And The admin clicks the "Customers" menu
    Then The admin verifies the "Customers" menu list is "expanded"
    And The admin clicks the "Customers" menu
    Then The admin verifies the "Customers" menu list is "collapsed"
    And The admin clicks the "Customers" menu
    And The admin clicks the sub menu "Customers" of Customer menu
    And The admin clicks the "Add new" button in Customers page
    And The admin enters the Customer details
    And Click Save button
    Then Verify the Customer added success message
    Then The admin verifies the newly added customer is displayed in Customer table
