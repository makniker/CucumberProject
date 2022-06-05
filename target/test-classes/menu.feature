Feature: Check menu list

  Scenario: I want to check menu list
    Given I log in and stay on main page as "Nikita Yermakov" with "+79922228316" and "Nikita123"
    When I click on drop-down menu
    Then should appear
      | "//*[@data-l = 't,userPage']" |
      | "//*[@data-l = 't,userFriend']" |
      | "//*[@data-l = 't,userPhotos']"|
      | "//*[@data-l = 't,userAltGroup']" |
      | "//*[@data-l = 't,appsShowcaseHD']" |
      | "//*[@data-l = 't,bizApps']" |
      | "//*[@data-l = 't,giftsFront']" |
      | "//*[@data-l = 't,mall']" |
      | "//*[@data-l = 't,discovery']" |
      | "//*[@data-l = 't,userStatuses']" |
      | "//*[@data-l = 't,payments']" |
      | "//*[@data-l = 't,bookmarks']" |
      | "//*[@data-l = 't,eventsCalendar']" |
      | "//*[@data-l = 't,photoWall']" |
      | "//*[@data-l = 't,challenges']" |
      | "//*[@data-l = 't,userFriendLive']" |
      | "//*[@data-l = 't,businessProfileCabinet']" |
      | "//*[@data-l = 't,adsManagerMain']" |
      | "//*[@data-l = 't,auctionsMain']" |
