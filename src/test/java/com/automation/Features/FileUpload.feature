@FileUpload
Feature: Demonstration of File upload. Choose a file on your system and then click upload. Or, drag and drop a file into the area below.

    Background: landing page
        Given a user is on the website home page
        When user clicks on File Upload

    Scenario Outline: Choosing a file on the system to upload
        Then user clicks on choose file
        And user clicks on upload button once file has been chosen
        And confirmation is displayed

    Scenario Outline: Drag and dop file to upload
        Then user drags a file from system into the website upload box