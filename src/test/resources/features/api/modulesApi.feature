Feature: Modules Api Tests
  Background: Connect to api
    Given I establish a connection to the api service
    
    Scenario: Basic create and delete module test
      When I send a POST request to "/api/modules" resource with following payload:
        | moduleName  | TEST MODULE6 |
        | videoLink   | none         |
        | moduleOrder | 10006        |
      Then Status code should bee 200
      When I send a GET request to "/api/modules" resource with name "TEST MODULE6"
      Then Status code should bee 200
      When I send DELETE request to "/api/modules" to delete newly created item
      Then Status code should bee 200