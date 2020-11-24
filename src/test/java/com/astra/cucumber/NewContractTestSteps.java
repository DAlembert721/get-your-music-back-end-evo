package com.astra.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewContractTestSteps {
    @Given("that the organizer want to send a contract to the musician")
    public void thatTheOrganizerWantToSendAContractToTheMusician() {
    }

    @Then("the response status code for this new contract request is {int}")
    public void theResponseStatusCodeForThisNewContractRequestIs(int arg0) {
    }

    @When("the organizer request to {string} to contract for an available time, date and location with the following data is valid")
    public void theOrganizerRequestToToContractForAnAvailableTimeDateAndLocationWithTheFollowingDataIsValid(String arg0) {
    }

    @When("the organizer request to {string} to contract for an available time, date and location with the following data is not valid")
    public void theOrganizerRequestToToContractForAnAvailableTimeDateAndLocationWithTheFollowingDataIsNotValid(String arg0) {
    }
}
