package com.astra.cucumber;

import com.astra.getyourmusic.resource.contractSaveResource.SaveContractResource;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NewContractTestSteps extends SpringIntegrationTest{
    SaveContractResource saveContractResource = new SaveContractResource();
    @Given("that the organizer want to send a contract to the musician")
    public void thatTheOrganizerWantToSendAContractToTheMusician() {
        saveContractResource.setStartDate("Contrato");
        saveContractResource.setAddress("mi casa");
        saveContractResource.setReference("Al lado del vecino");
        saveContractResource.setStartDate("2020-05-09T20:00:00");
        saveContractResource.setEndDate("2020-05-10T05:00:00");
    }

    @Then("the response status code for this new contract request is {int}")
    public void theResponseStatusCodeForThisNewContractRequestIs(int code) {
        assertThat(response.value(), is(code));
    }

    @When("the organizer request to {string} to contract for an available time, date and location with the following data is valid")
    public void theOrganizerRequestToToContractForAnAvailableTimeDateAndLocationWithTheFollowingDataIsValid(String url) throws Exception{
        executePost(url, saveContractResource);
    }

    @When("the organizer request to {string} to contract for an available time, date and location with the following data is not valid")
    public void theOrganizerRequestToToContractForAnAvailableTimeDateAndLocationWithTheFollowingDataIsNotValid(String url) throws Exception{
        saveContractResource = null;
        executePost(url, saveContractResource);
    }

}
