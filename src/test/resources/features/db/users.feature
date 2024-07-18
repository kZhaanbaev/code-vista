Feature: Users table tests

  @users-table
  Scenario: user count test
    Given I connect to database
    When I send a query to get users with a limit 5
    Then Verify I get 5 users only