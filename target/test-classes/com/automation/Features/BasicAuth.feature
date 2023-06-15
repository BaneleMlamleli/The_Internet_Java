@BasicAuth
Feature: Login windows for authentication

    Background: landing page
        Given a user is on the website home page

    Scenario Outline: Enter correct and incorrect login credentials for authentication
        When user clicks on basic auth
        And user enters the <password> and <username>
        Then user clicks on the sign in button
        And login status
        Examples:
            | password | username     |
            | admin    | admin        |
            | wrong_pw | wrong_usernm |