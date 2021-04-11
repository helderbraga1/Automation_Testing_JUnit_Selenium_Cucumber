@TC004
Feature: Test case TC004, fail to register user if empty password using REST

  @PerformTestTC004
  Scenario:  Create a new User by giving name and job
    Given I insert a valid email "challenge@automation.com"
    Given I insert an empty password ""
    Given I validate the user registration failed
