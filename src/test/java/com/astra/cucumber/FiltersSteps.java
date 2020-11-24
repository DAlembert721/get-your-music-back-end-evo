package com.astra.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FiltersSteps {
    @Given("I am an organizer")
    public void iAmAnOrganizer() {
    }

    @When("I select a filter and make a request to {string}")
    public void iSelectAFilterAndMakeARequestTo(String arg0) {
    }

    @Then("the result list should be a status code of {int}")
    public void theResultListShouldBeAStatusCodeOf(int arg0) {
    }

    @And("response with an empty list")
    public void responseWithAnEmptyList() {
    }
}
