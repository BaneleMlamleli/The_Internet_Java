@add_and_remove_element
Feature: Add and remove an element

    Background: landing page
        Given a user is on the website home page

    Scenario Outline: Add and remove an element
        When the user clicks on the AddRemoveElements on the website
        And the user clicks on the button AddElement
        Then the button Delete is displayed
        # The 'delete' button has been added, the below will remove the button
        And the user clicks on the button Delete
# And the driver process is killed