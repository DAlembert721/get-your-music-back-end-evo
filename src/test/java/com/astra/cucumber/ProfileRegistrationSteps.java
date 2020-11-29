package com.astra.cucumber;

import com.astra.getyourmusic.resource.userSaveResource.SaveProfileResource;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProfileRegistrationSteps extends SpringIntegrationTest{
    SaveProfileResource saveProfileResource = new SaveProfileResource();
    @Given("I'm a organizer and I have entered my data")
    public void iMAOrganizerAndIHaveEnteredMyData() {
        saveProfileResource.setEmail("email@email.com");
        saveProfileResource.setPassword("password");
        saveProfileResource.setFirstName("Name");
        saveProfileResource.setLastName("lastName");
        saveProfileResource.setType("Organizer");

    }


    @Then("the response for this request should be a status code of {int}")
    public void theResponseForThisRequestShouldBeAStatusCodeOf(int code) {
        assertThat(response.value(), is(code));
    }

    @Given("I'm a musician and I have entered my data")
    public void iMAMusicianAndIHaveEnteredMyData() {
        saveProfileResource.setEmail("email@email.com");
        saveProfileResource.setPassword("password");
        saveProfileResource.setFirstName("Name");
        saveProfileResource.setLastName("lastName");
        saveProfileResource.setType("Musician");
    }

    @Given("I'm a musician organizer and I have entered my data")
    public void iMAMusicianOrganizerAndIHaveEnteredMyData() {
        saveProfileResource = null;
    }

    @When("I want create a user with a post request to {string} with the following data required is valid for a organizer")
    public void iWantCreateAUserWithAPostRequestToWithTheFollowingDataRequiredIsValidForAOrganizer(String url) throws Exception{
        executePost(url, saveProfileResource);
    }

    @When("I want create a user with a post request to {string} with the following data required is valid for a musician")
    public void iWantCreateAUserWithAPostRequestToWithTheFollowingDataRequiredIsValidForAMusician(String url) throws Exception{
        executePost(url, saveProfileResource);
    }

    @When("I want create a user with a post request to {string} with the following data required is not valid for a musician")
    public void iWantCreateAUserWithAPostRequestToWithTheFollowingDataRequiredIsNotValidForAMusician(String url) throws Exception{
        executePost(url, saveProfileResource);
    }
}
