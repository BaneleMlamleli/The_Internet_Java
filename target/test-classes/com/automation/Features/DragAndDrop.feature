@DragAndDrop
Feature: Demonstration when elements are dragged and dropped.

    Background: landing page
        Given a user is on the website home page

    Scenario: Dragging and dropping elements
        When user clicks on drag and drop element
        Then drag and drop box A to box B