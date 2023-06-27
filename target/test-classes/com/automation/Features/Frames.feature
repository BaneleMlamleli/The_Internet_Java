@Frames
Feature: Demonstration of Frames

    Background: landing page
        Given a user is on the website home page
        When user clicks on Frames

    Scenario Outline: Nested Frames
        Then user clicks on Nested Frames
        And confirm all frames are displayed

    Scenario Outline: iFrame
        Then user clicks on iFrames and confirms iframe is displayed
