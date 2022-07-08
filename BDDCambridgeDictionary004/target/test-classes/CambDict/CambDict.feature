Feature: Cambridge Dictionary Link
Scenario:Successful navigation to Home Page 
    Given User navigate to home page
    When User validate on cambridge logo icon
   Then User should be navigated to the validation of cambridge logo

Scenario: User is on Cambridge Dictionary homepage
    Given User navigate to home page and validate the  WORD OF THE DAY link
    When User clicks on Word of the day link
    Then User see the meaning of word on another page

Scenario: Successful search of words with their meanings
    
		When User navigate in serch window  
		Then User have enters the words in search box And gets the meaning of their desired words
  
   |avalanche|hysterical|turncoat|
     
Scenario: successful navigation to facebook page
 Given user navigate to the facebook icon
 When  user look for the facebook page
 Then user should be navigated to cambridge facebook homepage