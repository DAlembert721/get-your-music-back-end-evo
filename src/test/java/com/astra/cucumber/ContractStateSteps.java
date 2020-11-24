package com.astra.cucumber;

import com.astra.getyourmusic.resource.contractSaveResource.SaveContractResource;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.joda.time.DateTime;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ContractStateSteps extends SpringIntegrationTest{
    SaveContractResource resource = new SaveContractResource();
    @Given("I am a musician")
    public void iAmAMusician() {
        resource = null;
    }

    @When("I want to accept the contract and make a put request to {string}")
    public void iWantToAcceptTheContractAndMakeAPutRequestTo(String url) throws Throwable{
        executePut(url, resource);
    }

    @Then("the result should be a status code of {int}")
    public void theResultShouldBeAStatusCodeOf(int code) {
        assertThat(response.value(), is(code));
    }

    @When("I want to reject the contract and make a put request to {string}")
    public void iWantToRejectTheContractAndMakeAPutRequestTo(String url) throws Throwable {
        executePut(url, resource);
    }
}
