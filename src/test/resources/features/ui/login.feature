Feature: Login Page Tests

#  @US100
#  Scenario: Login Test with correct credentials
#    Given I login to code-vista app as "student"
#    Then Verify title of the page should contain Home

  @US101
  Scenario: Login Test with correct credentials
    Given I login to code-vista app as "admin"
    Then "Admin" navigation button should be visible