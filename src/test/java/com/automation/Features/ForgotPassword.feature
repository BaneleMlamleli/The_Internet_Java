@ForgotPassword
Feature: Demonstration of password reset.

    Background: landing page
        Given a user is on the website home page
        When user clicks on Forgot Password

    Scenario: Password reset
        Then user enter their email address <email_address>
        And user clicks on retrieve password button
        Examples:
            | email_address                       |
            | 20489-52348oiweogg#l;aksdf.com.test |
            | mlamlelibanele@yahoo.com            |