@JQueryUIMenu
Feature: Demonstration of JQueryUI Menu

    Background: landing page
        Given a user is on the website home page
        When user clicks on JQueryUI Menu

    Scenario: JQueryUI - Downloading documents
        Then user download all documents

    Scenario: Back to JQuery Menu
        And user clicks on back to jquery ui