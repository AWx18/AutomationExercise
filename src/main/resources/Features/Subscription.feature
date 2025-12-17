Feature: Email Subscription

  Scenario: TC10 - Subscribe with valid email
    Given the user scrolls to the footer
    When the user enters an email to subscribe
    Then a subscription success message should appear
