Feature: ProfileRegistration
  In order to register
  As a Musician/Organizer
  I want to create an account with the required data to access the experience that it offers me

  Scenario: The data entered is valid
    Given I'm a organizer and I have entered my data
    When I want create a user with a post request to "/districts/1/profiles" with the following data required is valid for a organizer
    Then the response for this request should be a status code of 202

  Scenario: The data entered is valid
    Given I'm a musician and I have entered my data
    When I want create a user with a post request to "/districts/1/profiles" with the following data required is valid for a musician
    Then the response for this request should be a status code of 202

  Scenario: The data entered is not valid
    Given I'm a musician organizer and I have entered my data
    When I want create a user with a post request to "/districts/7/profiles" with the following data required is not valid for a musician
    Then the response for this request should be a status code of 400