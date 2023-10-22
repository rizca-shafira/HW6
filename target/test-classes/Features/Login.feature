#Author : Rizca Shafira Salsabila Makasuci
#Data : 20 Oktober 2023

@SmokeFeature
Feature: Feature to test login functionality

  @SmokeTest
  Scenario: User login using registered dan correct credentials (email and password)

    Given the user launches the web app
    When the user inputs a registered username
    And the user inputs the correct password for the given username
    And the user clicks the Login button
    Then the user should be logged in successfully
