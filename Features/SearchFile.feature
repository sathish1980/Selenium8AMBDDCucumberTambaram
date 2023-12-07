#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  Scenario Outline: To verify the flight search with Valid from and to location with mutilple data
    Given Launch the Browser and Enter the URL
    And Click On Adds If Exist
    When I Select From <FromLocation> FromDropdown
    And I Select To <ToLocation> From ToDropdown
    And I Select Depature <Date> From Depature
    And I Click On Search Button
    And I should get a OKGOTIT Popup and Upcon clicking OK
    Then I Should get the Search Result based on the given input

    Examples: 
      | FromLocation | ToLocation | Date |
      | MAA          | BLR        |   30 |
      | PNQ          | MAA        |   30 |