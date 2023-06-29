@KeyPress
Feature: Demonstration of key presses used to interact with a website (e.g., tab order, enter, escape, etc)

    Background: landing page
        Given a user is on the website home page
        When user clicks on Key Press

    Scenario: JavaScript Onload Event Error
        Then user presses any keyboard buttons

