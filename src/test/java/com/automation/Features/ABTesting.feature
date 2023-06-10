@AB_Test_Variation
Feature: A/B Test variation 1

    Scenario Outline: Test clicking redirection element
        Given a user is on the website home page
        When the user click on the A/B Testing element
        Then the user is redirected to the A/B Testing variation page
        And the driver process is killed