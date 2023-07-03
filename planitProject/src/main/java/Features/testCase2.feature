Feature: Validate the feedback form
  Scenario: Validate successful submission message

    Given The Planit Home Page
    When From the home page go to contact page
    When Populate mandatory fields
    Then Validate successful submission message
    And Close the browser