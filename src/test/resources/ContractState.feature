Feature: ContractState
  As a musician
  I want to review the contract received
  To Know whether to accept it or not

  Scenario: Contract status changed to accepted
    Given I am a musician
    When I want to accept the contract and make a put request to "/contracts/54/contractStates/2"
    Then the result should be a status code of 200

  Scenario: Contract status changed to rejected
    Given I am a musician
    When I want to reject the contract and make a put request to "/contracts/52/contractStates/3"
    Then the result should be a status code of 200