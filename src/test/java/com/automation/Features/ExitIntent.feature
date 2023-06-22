@ExitIntent
Feature: Demonstration of Modal with Mouse out of the viewport pane and see a modal window appear.

    Background: landing page
        Given a user is on the website home page
        When user clicks on Exit Intent

    Scenario: Clicking Modal
        Then move mouse out of the viewport pane and click on close button on the modal