package steps;
import com.google.common.net.MediaType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class NewContractTestStepDefinitions {

    final static String ROOT_URI = "http://localhost:8080/api";
    Response response;
    RequestSpecification httpRequest = given();

    @Given("that the organizer want to send a contract to the musician")
    public void that_the_organizer_want_to_send_a_contract_to_the_musician() {

    }

    @When("the organizer request to {string} to contract for an available time, date and location with the following data {string}")
    public void the_organizer_request_to_to_contract_for_an_available_time_date_and_location_with_the_following_data(String url, String postDataJSON){
        httpRequest.contentType(ContentType.JSON).body(postDataJSON);
        response = httpRequest.post(ROOT_URI + url);
    }

    @Then("the response status code for this new contract request is {int}")
    public void the_response_status_code_for_this_new_contract_request_is(int code) {

        Assert.assertEquals(code,response.getStatusCode());
        System.out.println("The body of post: ->  " + response.getBody().asString());

    }


}
