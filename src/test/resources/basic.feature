Feature: Automated test
  Using SuiteCRM online demo page, thank you SuiteCRM!

  Background: 
    Given I use the test user "mchq2019" with password "mctest" to login

  Scenario: Profile Check and Log out
    Then I can see USERNAME as "mchq2019"
    Then I can logout, mission accomplished
