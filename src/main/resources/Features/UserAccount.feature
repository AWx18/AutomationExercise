Feature: User Account Management

  Background:
    Given the user is on the home page

  Scenario: TC1 - Register a new user
    When the user navigates to signup page
    And the user enters valid signup information
    And the user fills account information
    Then the account should be created successfully
    And the user should be logged in
    When the user deletes the account
    Then the account should be deleted successfully

  Scenario: TC2 - Login with valid credentials
    When the user navigates to login page
    And the user enters valid credentials
    Then the user should be logged in again

  Scenario: TC3 - Login with invalid credentials
    When the user navigates to login page
    And the user enters invalid credentials
    Then an error message should appear

  Scenario: TC4 - Logout user
    When the user logs in with valid credentials
    And the user clicks logout
    Then the user should be redirected to login page

  Scenario: TC5 - Register with existing email
    When the user navigates to signup page
    And the user enters an already registered email
    Then an email already exists message should appear
