@DynamicallyLoading
Feature: Demonstration of loading when action gets triggered that returns a result dynamically. It does not rely on the page to reload or finish loading. The page automatically gets updated through the use of JavaScript.

    Background: landing page
        Given a user is on the website home page
        When user clicks on Dynamically Loading

    Scenario Outline: Example 1: Element on page that is hidden
        And user clicks on example 1
        Then start button is displayed and user clicks on the button
        And waiting for loading counter
        And Hello World is displayed

    Scenario Outline: Example 2: Element rendered after the fact
        And user clicks on example 2
        Then start button is displayed and user clicks on the button
        And waiting for loading counter
        And Hello World is displayed