Feature: Modules Table Tests

  Scenario: Verify limit count on get query
    Given I connect to database
    When I send a query to get modules table with a limit 5
    Then Verify I get 5 modules only from db