Feature: I want to test login in OK

  Scenario Outline: I want to login with correct credentials
    Given I Open login page
    When I login as <name> with <login> and <password>
    Then I have been successfully logged
    Examples:
      | name  |  login | password     |
      | "Nikita Yermakov" | "+79922228316" | "Nikita123" |
      | "Nadya" | "+79218824786" |  "raweryU78" |
      | "" | "" |  "" |
      | "aks" | "AOCOKNAONCOA[PN" |  "kanvlknalnlkalvalnvlkanlvknadlknvlkadnvk'ankvnal'knvlkanvknadkvnoanvonadonv" |
