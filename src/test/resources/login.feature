Feature: Login

  Scenario: Valid login
    Given I am at the login page
    When I type in a username of "john_doe"
    And I type in a password of "abc12345"
    And I click the login button
    Then I should be redirected to the success page

  Scenario: Invalid Login
    Given I am at the login page
    When I type in a username of "asdfasdfsd"
    And I type in a password of "asdfsdfkjsdkfjlj"
    And I click the login button
    Then I should receive an error message of "Username and/or password is incorrect"