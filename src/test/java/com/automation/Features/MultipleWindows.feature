@MultipleWindows
Feature: Demonstration of opening a new window.

    Background: landing page
        Given a user is on the website home page
        When user clicks on Multiple Windows

    Scenario: Open a new window
        Then open new window and confirm new window is opened