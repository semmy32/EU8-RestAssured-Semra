
@LUE-1014
Feature: Upload functionality
  US02_As a user, I should be able to upload files and pictures as messages

  Background: user is on the homepage
    Given as a user I am on the BleuCRM homepage

@LUE-1004
  Scenario: Upload multiple files at the same time (Test with max 3 files)
    When I click on MESSAGE button and then Upload files icon
    And upload three files at the same time
    Then I should see all together uploaded files name list

@LUE-1006
  Scenario: Upload files in different formats.
    When I click on MESSAGE button and then Upload files icon
    And upload files in different formats as specified
    Then I should see specified formatted files at attached files section

@LUE-1007
  Scenario: Upload files in undefined formats
    When I click on MESSAGE button and then Upload files icon
    And upload HTML and excel files
    Then HTML and excel files couldn't be uploaded

@LUE-1008 @wip
  Scenario:  Upload pictures
    When I click on MESSAGE button and then Upload files icon
    And upload pictures in JPEG, PNG and GIF formats
    Then I should see uploaded picture files name list

  @LUE-1009
  Scenario: Display the uploaded picture itself in Activity Stream.
    When I click on MESSAGE button and then Upload files icon
    And I upload picture in JPEG, PNG or GIF formats
    Then I should see uploaded picture itself in Activity Stream.

  @LUE-1010
  Scenario: Insert the files and images into the text
    When I click on MESSAGE button and then Upload files icon
    And upload files and click to insert button
    Then I should see inserted file in message box

  @LUE-1011
   Scenario: Allow a recipient to edit documents.
     When I click on MESSAGE button and then Upload files icon
     And upload files in different formats as specified
     Then I should allow a recipient to edit documents.


  @LUE-1012
   Scenario: Remove files and images at any time before sending.
     When I click on MESSAGE button and then Upload files icon
     And upload files in different formats as specified
     Then I should be able to remove files and images at any time before sending


  @LUE-1013 @wip
   Scenario: Rename the file before sending it.
     When I click on MESSAGE button and then Upload files icon
     And upload files
     Then I should be able to rename the file before sending it.