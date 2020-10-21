package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class ProfileRegistrationStepDefinitions {

    final static String ROOT_URI = "http://localhost:8080/api";
    Response response;
    RequestSpecification httpRequest = RestAssured.given();

     @Given("I'm a organizer and I have entered my data")
     public void i_m_a_organizer_and_I_have_entered_my_data() {
     }

    @When("I want create a user with a post request to {string} with the following data required {string}")
    public void i_want_create_a_user_with_a_post_request_to_with_the_following_data_required(String url, String postDataJSON) {
        httpRequest.contentType(ContentType.JSON).body(postDataJSON);
        response = httpRequest.post(ROOT_URI + url);
    }

    @Then("the response for this request should be a status code of {int}")
    public void the_response_for_this_request_should_be_a_status_code_of(int code) {
        Assert.assertEquals(code,response.getStatusCode());
        System.out.println("The body of post: ->  " + response.getBody().asString());
    }

    @Given("I'm a musician and I have entered my data")
    public void i_m_a_musician_and_I_have_entered_my_data() {
    }

    @Given("I'm a musician organizer and I have entered my data")
    public void i_m_a_musician_organizer_and_I_have_entered_my_data() {
    }
}
