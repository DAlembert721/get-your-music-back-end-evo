package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class FilterStepDefinitions {

    final static String ROOT_URI = "http://localhost:8080/api";
    Response response;
    RequestSpecification httpRequest = RestAssured.given();


    @Given("I am an organizer")
    public void i_am_an_organizer() {
    }

    @When("I select a filter and make a request to {string}")
    public void i_select_a_filter_and_make_a_request_to(String url)   {
        response = httpRequest.request(Method.GET, ROOT_URI + url );

    }


    @Then("the result list should be a status code of {int}")
    public void the_result_list_should_be_a_status_code_of(int code) {
        Assert.assertEquals(code,response.getStatusCode());
        if (response.getBody().asString().length() != 2){
            String responseBody = response.getBody().asString();
            System.out.println("Response Body with code 200 is =>  " + responseBody);
        }

    }

    @Then("response with an empty list")
    public void response_with_an_empty_list() {
        int empty = response.getBody().asString().length();
        Assert.assertEquals(2,empty);
        System.out.println("Response Empty List =>  " + response.getBody().asString());
    }
}
