@JavaScriptAlerts
Feature: Demonstration of JavaScript Alerts

    Background: landing page
        Given a user is on the website home page
        When user clicks on JavaScript Alerts

    Scenario: JavaScript Alerts
        Then user clicks on button JS Alert and clicks Ok button on the Alert
        And user clicks on button JS Confirm  and click Confirm button on the Alert
        And user clicks on button JS Prompt and user enter text then click Ok button