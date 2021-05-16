@wallethub
Feature: Find the Vaccine centers and extract them to a spreadsheet

  Scenario Outline: Capture all the vaccine centers info from Cowin website
    Given I select the browser "<browser>"
    And I open the Cowin website
    Examples:
      | browser |
      | Chrome  |
      | Firefox |
      | Edge    |