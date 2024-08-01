Feature: Submissions Tests
  Background: Connect to api
    Given I establish a connection to the api service

  Scenario: Verify I can fetch Submissions by user id
    When I send a GET request to "/api/submissions/by-user" resource with id 96
    Then Status code should bee 200

    Scenario: Create a new submission Test
      When I send a POST request to "/api/submission" resource with following payload:
        | userId      | 96               |
        | taskId      | 223              |
        | taskName    | Test             |
        | instruction | Test Instruction |
        | code        | Test Code        |
        | status      | Submitted        |
        | moduleName  | TEST MODULE      |
      Then Status code should bee 201
      When I send GET request to "/api/submission" resource with userId 96 and taskName "Test"
      Then Status code should bee 200
      When I send DELETE request to "/api/submission" to delete newly created item
      Then Status code should bee 200