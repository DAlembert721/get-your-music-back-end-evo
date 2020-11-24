Feature: NewContract
  As organizer
  I want to offer a contract to a musical artist
  In order to contract his


  Scenario: If the data of the contract is valid
    Given that the organizer want to send a contract to the musician
    When the organizer request to "/organizers/1/musicians/6/districts/2/contracts" to contract for an available time, date and location with the following data is valid
    Then the response status code for this new contract request is 200

  Scenario: If the data of the contract is not valid
    Given that the organizer want to send a contract to the musician
    When the organizer request to "/organizers/1/musicians/6/districts/2/contracts" to contract for an available time, date and location with the following data is not valid
    Then the response status code for this new contract request is 400