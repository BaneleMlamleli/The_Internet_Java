@RedirectLink
Feature: Demonstration of separation from directly returning a redirection status code, in that some browsers cannot handle a raw redirect status code without a destination page as part of the HTTP response.

    Background: landing page
        Given a user is on the website home page
        When user clicks on Redirect Link

    Scenario: Redirect Link
        And user clicks link to trigger the redirect
        Then test listed status codes