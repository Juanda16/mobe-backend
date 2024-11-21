Feature: As a user I want to see the list of categories

  Scenario: Server is up
    Given The user is on the home page
    When The user request the test endpoint
    Then The user should see the message "server is up and running"

  Scenario: Right status code
    Given The user is on the categories page
    When The user request the list of categories
    Then The user get the status code 200

  Scenario: List of categories
    Given The user is on the categories page
    When The user request the list of categories
    Then The user should see the list of categories

  Scenario Outline: Get an specific category by id
    Given The user is on the categories page
    When The user request the category with id <id>
    Then The user should see the category with id <id>

    Examples:
      | id |
      |  1 |
      |  2 |
      |  3 |
