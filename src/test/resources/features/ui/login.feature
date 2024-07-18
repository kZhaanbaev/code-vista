@loginTests
Feature: Login Page Tests

  @US100
  Scenario: Login Test with correct credentials
    Given I login to code-vista app as "student"
    Then Verify title of the page should contain Home