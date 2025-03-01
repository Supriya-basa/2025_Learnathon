Feature: Selenium Practice

  Scenario: Fill out text boxes and validate output
    Given the user opens the form page
    When the user enters values into the text boxes
    And clicks the submit button
    Then the output text should match the input values

  @OpenBrowser
  Scenario: Open Google Homepage
    Given the user opens the Google homepage
    Then the Google homepage should be displayed

  Scenario: Search for a term on Google
    Given the user opens the Google homepage
    When the user searches for a term
    Then the search results should be displayed

  Scenario: Navigate to Example homepage
    Given the user opens the Example homepage
    Then the Example homepage should be displayed

  Scenario: Verify page title
    Given the user opens the Example homepage
    Then the page title should be correct

  Scenario: Click a link
    Given the user opens the Example homepage
    When the user clicks a link
    Then the user should be redirected to the correct page

  Scenario: Use implicit wait
    Given the user sets an implicit wait
    When the user opens the Example homepage
    Then the Example homepage should be displayed

  Scenario: Use explicit wait
    Given the user opens the Example homepage
    When the user waits for an element to be visible
    Then the element should be displayed

  Scenario: Handle alert
    Given the user opens the alert page
    When the alert is displayed
    Then the user should accept the alert

  Scenario: Handle new window
    Given the user opens the Example homepage
    When the user clicks a link that opens a new window
    Then the user should switch to the new window
    And the new window should be displayed

  Scenario: Handle dropdown
    Given the user opens the Example homepage
    When the user selects an option from a dropdown
    Then the option should be selected

  Scenario: Fill out form
    Given the user opens the form page
    When the user fills out the form
    And submits the form
    Then the form should be submitted successfully