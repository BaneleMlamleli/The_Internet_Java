@BrokenImages
Feature: Checking image if it's visible and not broken
    Background: landing page
        Given a user is on the website home page

    Scenario: Checking image is not broken
        When user clicks on broken images
        Then check images