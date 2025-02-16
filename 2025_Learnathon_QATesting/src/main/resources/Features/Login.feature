Feature: Login Functionality

  @LoginSuccess
  Scenario: Successful Login
    Given the user is on the login page
    When the user enters valid credentials
    And clicks the login button
    Then the user is redirected to the homepage
    And a welcome message is displayed

    @LoginUnsuccessful
  Scenario: Unsuccessful Login
    Given the user is on the login page
    When the user enters invalid credentials
    And clicks the login button
    Then an error message is displayed
    And the user remains on the login page

