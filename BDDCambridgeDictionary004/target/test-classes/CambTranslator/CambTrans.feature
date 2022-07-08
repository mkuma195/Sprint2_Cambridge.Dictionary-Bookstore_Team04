Feature: Grammer and Translator in Cambridge Dictionary
 
    Given User is on cambridge home page
 
Scenario: Successful translation

    When User clicks on translate icon 
    And User enters a sentence in English  to translate

    |English|Japnese|Good|
    |English|Spanish|Bad|
    |English|German|Sweet|
 
    Then The sentence is tranlated in the desired language
Scenario: Successful exploration of Adjective and adverb from of desired word
    When user clicks on Adjective and adverb
    Then user gets the description about Adjective and adverb from of word

 Scenario: Successful exploration of Easily confused words from of desired word
   When user clicks on Easily confused words
    Then  user gets the description about Easily confused words from of word

 Scenario: Successful exploration of Noun,pronouns and determiners from of desired word
    When  user clicks on Noun,pronouns and determiners
    Then user gets the description about Noun,pronouns and determiners from of word 
    
 Scenario: Successful exploration of Prepositions and particles from of desired word
    When user clicks on Prepositions and particles 
    Then user gets the description about Prepositions and particles from of word 
    
  Scenario: Successful exploration of Using English from of desired word
    When  user clicks on Using English
    Then user gets the description about Using English from of word
     
  Scenario:  Successful exploration of Verbs from of desired word
    When  user clicks on Verbs
    Then user gets the description about Verbs from of word
    
     Scenario:  Successful exploration of Words, sentences and clauses from of desired word
    When  user clicks on Words,sentences and clauses
    Then user gets the description about Words,sentences and clauses from of word