#Author : Rizca Shafira Salsabila Makasuci
#Data : 20 Oktober 2023

@SmokeFeature
Feature: Feature to test showing product functionality

  @SmokeTest
  Scenario: Show product list when user goes to the product list page after logging in

    Given the user is already successfully logged in
    When the user opens the inventory/product list page
    Then the user can see the list of products
