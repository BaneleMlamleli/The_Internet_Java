@EntryAd
Feature: Demonstration of Modal.

    Background: landing page
        Given a user is on the website home page
        When user clicks on Entry Ad

    Scenario: Clicking Modal to close it and triggering a Modal to display
        And check modal is display
        And to re-enable it click link
        Then click on close button on the modal