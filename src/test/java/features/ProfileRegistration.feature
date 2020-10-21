Feature: ProfileRegistration
  In order to register
  As a Musician/Organizer
  I want to create an account with the required data to access the experience that it offers me

  Scenario: The data entered is valid
    Given I'm a organizer and I have entered my data
    When I want create a user with a post request to "/districts/4/profiles" with the following data required ' {"email": "musician@gmail.com","password" : "12casdsdc534","firstName" : "musico ","lastName" : "sjjsd2das323","type" : "Musician"}'
    Then the response for this request should be a status code of 202

  Scenario: The data entered is valid
    Given I'm a musician and I have entered my data
    When I want create a user with a post request to "/districts/3/profiles" with the following data required '{"email": "organizer@gmail.com","password" : "12casdsdc534","firstName" : "organizer ","lastName" : "sjjsd2das323","type" : "Organizer"}'
    Then the response for this request should be a status code of 202

  Scenario: The data entered is not valid
    Given I'm a musician organizer and I have entered my data
    When I want create a user with a post request to "/districts/7/profiles" with the following data required '{ "email": "vivemdias@gmail.com","password" : "12casdsdc534", "type" : "Musician" }'
    Then the response for this request should be a status code of 400