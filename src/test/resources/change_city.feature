Feature: I want to test change city for user

  Scenario: I want to change city and confirm it
    Given I log in and go to settings page by "Nikita Yermakov" with "+79922228316" and "Nikita123"
    When I write native city "Дели "
    Then I have successfully changed info about living place