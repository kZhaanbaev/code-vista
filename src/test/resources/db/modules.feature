Feature: Modules table test


  Scenario: module count test
    Given I connect to database
    When I send a query to get module count 10
    Then Verify module count of the ResultSet is 10