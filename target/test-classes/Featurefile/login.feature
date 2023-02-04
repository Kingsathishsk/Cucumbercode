Feature: To validate the Login functionality

  Scenario Outline: To verify login using valid and invalid credential
    Given user launch Facebook application
    When user enter "<username>" and "<password>"
    And user click Login button
    Then user see the results based on "<credentialType>"

    Examples: 
      | username | password | credentialType |
      | abc      | abc@123  | negative       |
      #  | rety     | Df@@123  | negative     |
      # | java     | java@123 | negative       |
    #  | hgy      | ghjj@123 | negative       |
