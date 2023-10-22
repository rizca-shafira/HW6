#Author : Rizca Shafira Salsabila Makasuci
#Data : 20 Oktober 2023

@SmokeFeature
Feature: Feature to test failed login functionality

  @SmokeTest
  Scenario: User login using unregistered username and incorrect password

    Given the user launches the web app
    When the user inputs an unregistered username
    And the user inputs an incorrect password for the username
    And the user clicks the Login button
    Then the user should not be able to log in