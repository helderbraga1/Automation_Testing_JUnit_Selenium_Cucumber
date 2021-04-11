@TC001
Feature: Runs the test case TC001 to check if value displayed is correct

  Background:
    Given I open chrome and launch the application

  @PerformTestTC001
  Scenario Outline: Go to the page, input plan data, click calculate

    When I select type "<type>"
    When I select support plan "<plan>"
    When I write monthly duration of "<duration>"
    When I click in calculate price button
    When I validate price is "<price>"
    Then I close the browser window

    Examples: Assert if plan price is correct
      |type     |plan         |duration|price    |
      |Special  |Full         |6       |2249.10 $|
      |Regular  |Full Extended|12      |2399.04 $|
      |Premium  |Plus         |3       |1574.37 $|
