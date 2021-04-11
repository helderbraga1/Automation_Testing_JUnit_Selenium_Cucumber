@TC003
Feature: Test case TC003, delete a user after checking a new one was created with REST

  @PerformTestTC003WithId
  Scenario Outline: Create a new User by giving name and job
    Given I delete the user by id "<id>"
    Given I validate the user was deleted

    Examples: Assert if user is created
      |id|
      |2 |

  @PerformTestTC003WithObject
  Scenario Outline: Create a new User, and proceed to delete it
    Given the user was created successfully "<name>" "<job>"
    Given I delete the previously created user
    Given I validate the user was deleted

    Examples: Assert if user is created
      |name  |job            |
      |Tobias|Manager        |
      |Peter |Office Worker  |
      |Mary  |Human Resources|
