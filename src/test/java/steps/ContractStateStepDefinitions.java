package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class ContractStateStepDefinitions {

    final static String ROOT_URI = "http://localhost:8080/api";
    Response response;
    RequestSpecification httpRequest = RestAssured.given();

    @Given("I am a musician")
    public void i_am_a_musician() {

    }

    @When("I want to accept the contract and make a put request to {string}")
    public void i_want_to_accept_the_contract_and_make_a_put_request_to(String url) {
         response = httpRequest.put(ROOT_URI + url);

    }

    @Then("the result should be a status code of {int}")
    public void the_result_should_be_a_status_code_of(int code) {
        Assert.assertEquals(code , response.getStatusCode());
    }

    @When("I want to reject the contract and make a put request to {string}")
    public void i_want_to_reject_the_contract_and_make_a_put_request_to(String url) {
        response = httpRequest.put(ROOT_URI + url);
    }

}
