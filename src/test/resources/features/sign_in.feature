Feature: Sign In
  In order to Sign In
  As a User
  I want authenticate onto the application

  Scenario: Unknown Attempted to Sign In
    Given I'm a Unknown User
    When I attempt to Sign into the application
    Then I will still be on the Sign in page

  Scenario: Admin Sign in
    Given I'm a Admin User
    When I Sign into the application
    Then I will see my Member Details

  Scenario: Standard Sign in
    Given I'm a Standard User
    When I Sign into the application
    Then I will see my Member Details

  Scenario: Suspended Sign in
    Given I'm a Suspended User
    When I Sign into the application
    Then I will see my Member Details