Feature: Validation of contact page
  Scenario: contact page validation

    Given The Planit Home Page
    When From the home page go to contact page
    Then Click submit button
    And Verify error messages
    When Populate mandatory fields
    Then Validate errors are gone
    And Close the browser
