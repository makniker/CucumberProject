Feature: I want to test login in OK

  Scenario: I want to login with correct credentials
    Given I go to login page
    When I login as "+79922228316" with password "Nikita123"
    Then I have been successfully logged
