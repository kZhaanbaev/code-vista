Feature: Modules table test


  Scenario: Verify limit count on get query
    When I send a query to get modules table with a limit 5
    Then Verify I get 5 modules only from db

  Scenario: Add new module to DB
    Given I connect to database
    When I add a new module with the following details:
      | module_id    | 3350      |
      | module_name  | Java APIs |
      | module_order | 78        |
      | video_link   | test      |
    And I send query to get data with "module_id" column name and value "3333" from "modules" table
    Then Verify module count is 1

  Scenario: Add module with an existing module_id
    Given I connect to database
    When I add a new module with the following details:
      | module_id    | 3349      |
      | module_name  | Java APIs |
      | module_order | 78        |
      | video_link   | test      |
    And I attempt to add another module with the same module_id:
      | module_id    | 3349      |
      | module_name  | Java APIs |
      | module_order | 99        |
      | video_link   | fail      |
    Then Verify an exception is thrown

  Scenario: update module_order value with a decimal number
    Given I connect to database
    When I update the "module_order" column which has 3340 id with "2.8" value
    And I send query to get data with "module_order" column name and value "2.8" from "modules" table
    Then Verify module count is 1