@Hover
Feature: Demonstration of mouse hovering on images

    Background: landing page
        Given a user is on the website home page
        When user clicks on Hovers

    Scenario: Mouse hovering on images
        Then user hovers on an image to display text below it