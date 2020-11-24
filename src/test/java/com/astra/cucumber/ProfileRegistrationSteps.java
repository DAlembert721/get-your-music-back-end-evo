package com.astra.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileRegistrationSteps {
    @Given("I'm a organizer and I have entered my data")
    public void iMAOrganizerAndIHaveEnteredMyData() {
    }


    @Then("the response for this request should be a status code of {int}")
    public void theResponseForThisRequestShouldBeAStatusCodeOf(int arg0) {
    }

    @Given("I'm a musician and I have entered my data")
    public void iMAMusicianAndIHaveEnteredMyData() {
    }

    @Given("I'm a musician organizer and I have entered my data")
    public void iMAMusicianOrganizerAndIHaveEnteredMyData() {
    }

    @When("I want create a user with a post request to {string} with the following data required is valid for a organizer")
    public void iWantCreateAUserWithAPostRequestToWithTheFollowingDataRequiredIsValidForAOrganizer(String arg0) {
    }

    @When("I want create a user with a post request to {string} with the following data required is valid for a musician")
    public void iWantCreateAUserWithAPostRequestToWithTheFollowingDataRequiredIsValidForAMusician(String arg0) {
    }

    @When("I want create a user with a post request to {string} with the following data required is not valid for a musician")
    public void iWantCreateAUserWithAPostRequestToWithTheFollowingDataRequiredIsNotValidForAMusician(String arg0) {
    }
}
