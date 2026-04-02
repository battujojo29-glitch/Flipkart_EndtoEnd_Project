Feature: To validate the Flipkart Application

  Background:
    Given Launch the Flipkart Application
    When  close the popup
    Then  it should Navigate to the Home page

  @tc001 @Regression
  Scenario: To validate the search functionality
    Given User enter the text in the search field
    When  click the search button
    Then  it should navigate to the search result page and display the relevant details
    And   select Minimum and Maximum Amount
    And   Select the Brand
    And   Select the Ram
    And   Select the Battery Capacity
    Then  It should display the Relevant result

  @tc002 @Regression
  Scenario: To validate the Fashion Functionality
    Given User to move the Fashion link
    When  Cursor to move to the Kids link
    And   Move to girls dress and click
    And   Click the price high to low link
    Then  it should display the relevant details and get the title

  @tc003
  Scenario Outline: To validate the search functionality with different values
    Given Enter the "<searchtext>" in the search field
    When  click the search button to search the text
    Then  it should navigate to the next page and display the corresponding page

    Examples:
      | searchtext |
      | Mobile     |
      | Tv         |
      | Speaker    |
      | Shirt      |
      
@tc004
Scenario: To validate upto addcart functionality

Given User can move to the login link
When User click the flipkart plus zone
And Mouse move to the Home&Furniture link
And Going to click the wall lamp
And Scroll down the page and click one particular result
And Enter delivery pincode and click the check link
Then Pincode should be checked and displayed and verify the titles


@tc005
Scenario:To get the title and price from search reult

Given Enter the search text in the search field
When  click the search icon
Then it should display the search result and get the title and price
	










