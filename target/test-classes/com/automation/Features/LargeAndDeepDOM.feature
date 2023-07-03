@LargeAndDeepDOM
Feature: Demonstration of pages that have very large and deeply nested page layouts, which can trigger odd rendering issues and test performance bottlenecks (depending on your locator strategy). These examples are nested 50 levels deep.

    Background: landing page
        Given a user is on the website home page
        When user clicks on Large And Deep DOM

    Scenario: Test rows and column values
        Then test all rows and column values