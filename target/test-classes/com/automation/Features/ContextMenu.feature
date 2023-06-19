@ContextMenu
Feature: Context menu items are custom additions that appear in the right-click menu. Right-click in the box to trigger a JavaScript alert.

    Background: landing page
        Given a user is on the website home page

    Scenario: Right-click in the box to trigger a JavaScript alert.
        When user clicks on Context Menu
        And user right-click on the box
        Then JavaScript alert is displayed
        And user clicks okay on the JavaScript alert button