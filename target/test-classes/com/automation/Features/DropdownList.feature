@Dropdown
Feature: Demonstration when dropdown list is click and an option is selected.

    Background: landing page
        Given a user is on the website home page

    Scenario: Dropdown list is click and an option is selected
        When user clicks on dropdown link
        Then user clicks on the dropdown element and select first option