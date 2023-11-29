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
Feature: To verify the search funcationlity in Makemytrip

  @tag1
  Scenario: To verify the flight search with Valid from and to location
    Given Launch the Browser and Enter the URL
    And Click On Adds If Exist
    When I Select From Location From FromDropdown 
    And I Select To Location From ToDropdown
    And I Select Depature Date From Depature
    And I Click On Search Button 
    And I should get a OKGOTIT Popup and Upcon clicking OK
    Then I Should get the Search Result based on the given input
   

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
