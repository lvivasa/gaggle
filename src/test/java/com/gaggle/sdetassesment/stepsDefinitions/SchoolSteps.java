package com.gaggle.sdetassesment.stepsDefinitions;

import com.gaggle.sdetassesment.asserts.SchoolAsserts;
import com.gaggle.sdetassesment.helpers.SchoolsHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.core.Serenity.setSessionVariable;

public class SchoolSteps {
    @Steps
    SchoolsHelper schools;

    @Steps
    SchoolAsserts schoolAsserts;

    @Given ("^I want to get the schools in memory$")
    public void iWantToGetTheSchoolsInMemory() {
        setSessionVariable("api").to("GET_ALL_SCHOOLS");
        schools.setRequestData();
    }

    @Given("^I want to get the school ID ([^\"]*)$")
    public void iWantToGetTheSchoolID(int schoolId) {
        setSessionVariable("api").to("GET_SPECIFIC_SCHOOL");
        setSessionVariable("id").to(schoolId);
        schools.setRequestData();
    }

    @Given ("^I want to add a school with the following information$")
    public void iWantToAddASchoolWithTheFollowingInformation(DataTable schoolInformation) {
        setSessionVariable("api").to("ADD_SCHOOL");
        setSessionVariable("datatable").to(schoolInformation);
        schools.setRequestData();
        schools.setSchoolDto();
    }

    @Given ("^I want to update the school Id ([^\"]*) with the following information$")
    public void iWantToUpdateTheSchoolIdWithTheFollowingInformation(int schoolId,DataTable schoolInformation) {
        setSessionVariable("api").to("UPDATE_SCHOOL");
        setSessionVariable("datatable").to(schoolInformation);
        setSessionVariable("id").to(schoolId);
        schools.setRequestData();
        schools.setSchoolDto();
    }

    @When("^I call the api$")
    public void iCallTheApi() {
        schools.callApi();
    }

    @Then ("^I get the array of schools objects$")
    public void iGetTheArrayOfSchoolsObjects() {
       schoolAsserts.validateSchoolArraySize();
    }

    @Then ("^I can see the school information$")
    public void iCanSeeTheSchoolInformation(DataTable dataTable) {
        setSessionVariable("datatable").to(dataTable);
        schools.setSchoolDto();
        schoolAsserts.validateSchoolInformation();
    }

    @Then ("^The status code is ([^\"]*)$")
    public void theStatusCodeIs(int statusCode) {
        schoolAsserts.validateStatusCode(statusCode);
    }

    @Then ("^The error message is ([^\"]*)$")
    public void theErrorMessageIs(String errorMessage) {
        schoolAsserts.validateErrorMessage(errorMessage);
    }

    @Then("^The school is updated$")
    @Then ("^The school is created$")
    public void theSchoolIsCreated() {
        schoolAsserts.validateStatusCode(200);
    }

    @Then ("^The information is correct$")
    public void theInformationIsCorrect() {
        schoolAsserts.validateSchoolInformation();
    }
}
