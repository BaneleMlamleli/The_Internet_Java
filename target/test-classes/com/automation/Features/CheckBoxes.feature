@CheckBoxes
Feature: Tick and untick Checkboxes to test if it's ticked or not

    Background: landing page
        Given a user is on the website home page

    Scenario: Tick and untick the Checkboxes
        When user clicks on Checkboxes
        Then user tick checkbox 1 and untick checkbox 2