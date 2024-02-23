#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Template

  @mono
  Scenario: Day Of Week
    Given caller is asked for a number
    When caller says 5
    Then caller is told the day is "Friday"

  @mono
  Scenario: Food Table
    Given nutritional die is important to individual health
    When we see a food table
      | food      | health_value | status |
      | apple     |            5 | good   |
      | ice cream |            1 | bad    |
      | walnut    |            4 | decent |
      | steak     |            3 | bad    |
    Then we choose to eat "good" food

  @data-driven @test
  Scenario Outline: Math Test
    Given user looks at the math problem <id>
    When user gets both the value <first> and the value <second>
    Then user performs the "<operation>" operation
    And user verify the value <result>

    Examples: 
      | id | first | second | operation | result |
      |  1 |   5.0 |    7.5 | multiply  |   37.5 |
      |  2 |   7.5 |    6.0 | subtract  |    1.5 |
      |  3 |   9.0 |    9.9 | add       |   18.9 |
      |  4 |  10.0 |    2.0 | divide    |    5.0 |
