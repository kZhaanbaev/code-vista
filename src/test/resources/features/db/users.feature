Feature: Users table tests

  @users-table
  Scenario: user count test
    Given I connect to database
    When I send a query to get users with a limit 5
    Then Verify I get 5 users only

  Scenario: Add new user to DB Test
    Given I connect to database
    When I create a new user with following details:
      | user_id    | 1234            |
      | first_name | John            |
      | last_name  | Blue            |
      | email      | j.blue@test.com |
      | password   | 123456          |
      | role       | student         |
    And I fetch data with "email" column name and value "j.blue@test.com" from "users" table
    Then Verify user count is 1