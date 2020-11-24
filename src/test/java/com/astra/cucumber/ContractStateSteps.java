package com.astra.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContractStateSteps {
    @Given("I am a musician")
    public void iAmAMusician() {
    }

    @When("I want to accept the contract and make a put request to {string}")
    public void iWantToAcceptTheContractAndMakeAPutRequestTo(String arg0) {
    }

    @Then("the result should be a status code of {int}")
    public void theResultShouldBeAStatusCodeOf(int arg0) {
    }

    @When("I want to reject the contract and make a put request to {string}")
    public void iWantToRejectTheContractAndMakeAPutRequestTo(String arg0) {
    }
}
