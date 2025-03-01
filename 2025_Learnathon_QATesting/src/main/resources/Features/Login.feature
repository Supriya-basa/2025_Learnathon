Feature: Login Functionality

  @LoginSuccess
  Scenario: Validate Successful Login
    Given the user is on the login page
    When the user enters valid credentials
    And clicks the login button
    Then the user is redirected to the homepage
    And a welcome message is displayed

  @LoginUnsuccessful
  Scenario: Verify Unsuccessful Login
    Given the user is on the login page
    When the user enters invalid credentials
    And clicks the login button
    Then an error message is displayed
    And the user remains on the login page

  @LoginEmptyFields
  Scenario: Validate Login with Empty Fields
    Given the user is on the login page
    When the user leaves the username and password fields empty
    And clicks the login button
    Then an error message is displayed
    And the user remains on the login page

  @LoginLockedAccount
  Scenario: Verify Login with Locked Account
    Given the user is on the login page
    When the user enters credentials for a locked account
    And clicks the login button
    Then an account locked message is displayed
    And the user remains on the login page

  @LoginInvalidUsername
  Scenario: Validate Login with Invalid Username
    Given the user is on the login page
    When the user enters an invalid username and valid password
    And clicks the login button
    Then an error message is displayed
    And the user remains on the login page

  @LoginInvalidPassword
  Scenario: Verify Login with Invalid Password
    Given the user is on the login page
    When the user enters a valid username and invalid password
    And clicks the login button
    Then an error message is displayed
    And the user remains on the login page

  @LoginCaseSensitivity
  Scenario: Validate Login with Case-Sensitive Credentials
    Given the user is on the login page
    When the user enters a valid username with incorrect case and valid password
    And clicks the login button
    Then an error message is displayed
    And the user remains on the login page