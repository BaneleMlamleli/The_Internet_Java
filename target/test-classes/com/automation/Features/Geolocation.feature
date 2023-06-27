@Geolocation
Feature: Demonstration of Google map geolocation

    Background: landing page
        Given a user is on the website home page
        When user clicks on Geolocation

    Scenario: Google map geolocation
        Then click on where am I button and accept alert
        And click on See it on Google