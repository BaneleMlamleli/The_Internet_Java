@ABTesting
Feature: A/B Test variation 1

    Background: landing page
        Given a user is on the website home page

    Scenario: Test clicking redirection element
        When the user click on the A/B Testing element
        Then the user is redirected to the A/B Testing variation page
# And close browser