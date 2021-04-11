@TC002
Feature: Runs the test case TC002, creating a new user using the REST API

  Background:
    Given I use user creation service

  @PerformTestTC002
  Scenario Outline: Create a new User by giving name and job
    Given I set name "<name>"
    Given I set job "<job>"
    Given I validate my response is correct

    Examples: Assert if user is created
      |name     |job        |
      |Toy      |singer     |
      |Peter    |Webmaster  |
      |Jonathan |UI Designer|
