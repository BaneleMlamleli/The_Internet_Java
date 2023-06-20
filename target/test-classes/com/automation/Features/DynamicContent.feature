@DynamicContent
Feature: Demonstration of content by loading new text and images on each page refresh.

    To make some of the content static append ?with_content=static or click here..

    Background: landing page
        Given a user is on the website home page

    Scenario: Loading new text and images on each page refresh
        When user clicks on dynamic content
        Then check images and text change