Feature: Mystore Test

  Scenario Outline: user can login and add new adress

    Given user is on the mystore-testlab website
    When user clicks Sign in
    When user inputs "<email>" address and "<password>" in Log in to your account section
    And user clicks Sign In button
    When user clicks Addresses button
    When user fills "<alias>" as Alias, "<address>" as Address, "<city>" as City, "<zip_postal_code>" as zip postal code, "<country>" as Country, "<phone>" as Phone
    And user clicks save
    Then Address is correctly added "<alias>" "<address>" "<city>" "<zip_postal_code>" "<country>" "<phone>"
    When user clicks Delete
    Then Address successfully deleted! is displayed


    Examples:
      | email            | password  | alias | address | city   | zip_postal_code | country        | phone     |
      | aaaaaaaaaa@wp.pl | qwerty123 | Main  | Bean10  | London | 00-188          | United Kingdom | 444123999 |
