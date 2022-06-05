Feature: Post something

  Scenario: I want to post something
    Given I log in on main page as "Nikita Yermakov" with "+79922228316" and "Nikita123"
    When I post "my text" on main page
    Then It should appear on it