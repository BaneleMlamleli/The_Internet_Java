@AddAndRemoveElement
Feature: Add and remove an element

    Background: landing page
        Given a user is on the website home page

    Scenario: Add and remove an element
        When the user clicks on the AddRemoveElements on the website
        And the user clicks on the button AddElement
        Then the button Delete is displayed
        And the user clicks on the button Delete
# And close browser