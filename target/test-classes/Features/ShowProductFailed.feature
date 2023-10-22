#Author : Rizca Shafira Salsabila Makasuci
#Data : 20 Oktober 2023

@SmokeFeature
Feature: Feature to test failing to show product functionality

  @SmokeTest
  Scenario: Not showing the product list and displaying a warning for non-logged-in user accessing the product list page

    Given the user hasn't yet logged in or is already logged out
    When the user fail to open the inventory/product list page
    Then the user can't see products
    And the page displays a warning that the user must be logged in to access the inventory page

