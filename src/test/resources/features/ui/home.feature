@homeTests
Feature: Home page Tests

  Background: Navigating to home page
    Given I login to salesforce app
    When I click "App Launcher" button
    And I click "Service" button

  @US107
  Scenario: Home page URL test
    Then Verify URL is ending with "/lightning/page/home"

  @US108
  Scenario: Navigation buttons on home page
    Then Verify "Accounts" navigation button is visible
    Then Verify "Contacts" navigation button is visible
    Then Verify "Kuba" navigation button is visible

  @US111
  Scenario: Home page navigation buttons
    Then Validate following nav buttons take you to correct page containing name of the button in URL:
      | Accounts   |
      | Contacts   |
      | Cases      |
      | Reports    |
      | Dashboards |

  @US111-1
  Scenario Outline: Home page navigation buttons
    Then Validate "<button name>" nav button takes you to correct page containing name of the button in URL:
    Examples:
      |button name |
      | Accounts   |
      | Contacts   |
      | Cases      |
      | Reports    |
      | Dashboards |
