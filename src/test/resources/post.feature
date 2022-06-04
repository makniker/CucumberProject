Feature: Post something

  Scenario: I want to login with correct credentials
    Given I log in and stay on main page as "Nikita Yermakov" with "+79922228316" and "Nikita123"
    When I post "my text" on main page
    Then It should appear on it