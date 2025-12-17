Feature: Contact Us Form

  Scenario: TC6 - Submit contact form
    Given the user is on the contact us page
    When the user fills the contact form
    And the user uploads a file
    And the user submits the form
    Then a success message should appear

  Scenario: TC12 - Contact form and return home
    Given the user is on the contact us page
    When the user fills the contact form
    And the user submits the form
    And the user returns to the home page
    Then the home page should be displayed
