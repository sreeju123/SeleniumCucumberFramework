Feature: Login Page Scenarios

  Scenario: Successful Login
    Given The admin navigates to "https://admin-demo.nopcommerce.com/login?returnurl=%2Fadmin%2F"
    And Clicks Submit button

  Scenario: Invalid URL Login
    Given The admin navigates to "https://www.google.com/"
    And Clicks Submit button