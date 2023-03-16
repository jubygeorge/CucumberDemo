Feature: Test the Login functionality of OrangeHRM

Scenario: Test valid Login

Given user is in Login Page
When user enters username and password
And user clicks on Login button
Then user will be forwarded to the Home Page
