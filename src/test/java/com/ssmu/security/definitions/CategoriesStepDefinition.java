package com.ssmu.security.definitions;

import static io.restassured.RestAssured.given;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoriesStepDefinition  {
    private final static String BASE_URI = "http://localhost";

    @LocalServerPort
	private int port;

	private ValidatableResponse validatableResponse;

	private void configureRestAssured() {
		RestAssured.baseURI = BASE_URI;
		RestAssured.port = port;
	}

    protected RequestSpecification requestSpecification() {
		configureRestAssured();
		return given();
	}



    @Given("The user is on the categories page")
    public void theUserIsOnTheCategoriesPage() {
        assert true;
        // validatableResponse = requestSpecification().contentType(ContentType.JSON).when().get("api_v1/categories/all").then();
		// System.out.println("RESPONSE :" + validatableResponse.extract().asString());
    }


    @When("The user request the list of categories")
    public void theUserRequestTheListOfCategories() {
       
        validatableResponse = requestSpecification().contentType(ContentType.JSON).when().get("api_v1/categories/all").then();
		System.out.println("RESPONSE :" + validatableResponse.extract().asString());
    }

    @Then("The user should see the list of categories")
    public void theUserShouldSeeTheListOfCategories() {
        validatableResponse.assertThat().body("size()", org.hamcrest.Matchers.greaterThan(0));
    }

    @Then("The user get the status code {int}")
    public void The_user_get_the_status_code(int statusCode) {
        validatableResponse.assertThat().statusCode(statusCode);
    }

    @When("The user request the category with id {int}")
    public void theUserRequestTheCategoryWithId(int id) {
        validatableResponse = requestSpecification().contentType(ContentType.JSON).when().get("api_v1/categories/" + id).then();
    }

    @Then("The user should see the category with id {int}")
    public void theUserShouldSeeTheCategoryWithId(int id) {
        validatableResponse.assertThat().body("id", org.hamcrest.Matchers.equalTo(id));
    }

    @Given("The user is on the home page")
    public void The_user_is_on_the_home_page() {
        assert true;
    }


    @When("The user request the test endpoint")
    public void The_user_request_the_test_endpoint() {
        validatableResponse = requestSpecification().contentType(ContentType.JSON).when().get("api_v1/test/").then();
    }

    @Then("The user should see the message {string}")
    public void The_user_should_see_the_message(String s) {
    
        validatableResponse.assertThat().body("message", org.hamcrest.Matchers.equalTo(s));
    }

    
}
