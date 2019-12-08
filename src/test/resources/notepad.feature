Feature: As I am a user, I write some notes,
  and I want to be sure that notepad saved correctly
  my notes

  Scenario Outline: create txt file with some message
    When I open notepad
    And I write "<message>" to notepad
    Then I click save as button
    And I set location: "<location>" to saving file
    And I set filename: "<filename>"
    And I save changes and close notepad
    And I finding in windows my new created file "<filename>"
    Then text in notepad must to be "<message>"

    Examples:
      | message                   | location       | filename      |
      | hello from autoit4java..) | C:/Users/admin | myNewNote.txt |
