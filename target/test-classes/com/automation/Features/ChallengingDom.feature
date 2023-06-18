@ChallengingDom
Feature:This example demonstrates that with unique IDs, a table with no helpful locators, and a canvas element.

    Background: landing page
        Given a user is on the website home page

    Scenario: using different non-unique and unique locators to locate elements
        When user clicks on Challenging Dom
        And user clicks on the blue, red, green button
        And user clicks on edit in the table
        Then url is appended with the word edit
        And user clicks on delete in the table
        Then url is appended with the word delete
        And the answer box changes the number at page load time
