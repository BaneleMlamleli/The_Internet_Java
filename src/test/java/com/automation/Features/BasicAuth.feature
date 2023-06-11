@BasicAuth
Feature: Login windows for authentication

    Background: landing page
        Given a user is on the website home page

    Scenario Outline: Enter correct and incorrect login credentials for authentication
        When login pop-up message box is displayed
        And user enters the <password> and <username>
        Then user clicks on the sign in button
        And login status

            | password   | username   |
            | admin_user | adminXYZ01 |
            | admin      | admin      |