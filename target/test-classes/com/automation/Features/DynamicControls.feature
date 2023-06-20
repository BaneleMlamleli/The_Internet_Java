@DynamicControls
Feature: Demonstration of content when elements (e.g., checkbox, input field, etc.) are changed asynchronously.

    Background: landing page
        Given a user is on the website home page
        When user clicks on dynamic controls

    Scenario Outline: Remove/Add - Elements (e.g., checkbox, input field, etc.) are changed asynchronously
        Then user tick the checkbox and clicks on remove button
        And wait for loading counter
        And Add button is displayed with "It's done" message
        And clicks on the Add button
        And wait for loading counter
        And Remove button is displayed with "It's back" message

    Scenario Outline: Enable/Disable - Elements (e.g., checkbox, input field, etc.) are changed asynchronously
        Then user clicks on enable button
        And wait for loading counter
        And message "It's enabled!" will be displayed
        And enter text in the text box and click on Disable again
        And user clicks on Disable button
        And wait for loading counter
        And message "It's disabled!" will be displayed
        And check to see text box is editable