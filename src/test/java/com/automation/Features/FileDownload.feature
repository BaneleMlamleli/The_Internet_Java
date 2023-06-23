@FileDownload
Feature: Demonstration of File Download

    Background: landing page
        Given a user is on the website home page
        When user clicks on File Download

    Scenario: Clicking on files to dowload
        Then user downloads all files