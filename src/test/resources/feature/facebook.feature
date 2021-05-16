@facebook
Feature: Login to facebook and post Hello World

  Scenario Outline: Post Hello World after logging into Facebook
    Given I select the browser "<browser>"
    And I open the Facebook website
    And I login by providing the username "100067733783120" and password "7b8c6r0umjp"
    And I navigate to the create post modal
    When I post the message "Hello World"
    Then the post "Hello World" should be successfully added
    Examples:
      | browser |
      | Chrome  |
      | Firefox |
      | Edge    |