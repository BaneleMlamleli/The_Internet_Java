@DisappearingElements
Feature: Demonstration when elements on a page change by disappearing/reappearing on each page load.

    Background: landing page
        Given a user is on the website home page

    Scenario: Elements on a page change by disappearing/reappearing on each page load
        When user clicks on disappearing elements
        Then check all elements are present