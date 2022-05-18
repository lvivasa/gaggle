package com.gaggle.sdetassesment.asserts;

import com.gaggle.sdetassesment.dtos.SchoolDTO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Map;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class SchoolAsserts {
    public void validateStatusCode(int expected){
        assertEquals("Status code is wrong",getResponse().statusCode(), expected);
    }

    public void validateErrorMessage(String expected){
       assertEquals("Error message is wrong",getBodyResponse().get("error").toString(), expected);
    }

    public void validateSchoolArraySize(){
        assertTrue("School list is empty",getArrayResponse().size()>0);
    }

    public void validateSchoolInformation(){
        SchoolDTO expectedSchoolDTO = sessionVariableCalled("schoolDTO");

        SchoolDTO currentSchoolDto = getObjectResponse();

        assertEquals("SchoolId is wrong",expectedSchoolDTO.getSchoolId(),currentSchoolDto.getSchoolId());
        assertEquals("SchoolName is wrong",expectedSchoolDTO.getSchoolName(),currentSchoolDto.getSchoolName());
        assertEquals("StudentCount is wrong",expectedSchoolDTO.getStudentCount(),currentSchoolDto.getStudentCount());
        assertEquals("EmailAddress is wrong",expectedSchoolDTO.getEmailAddress(),currentSchoolDto.getEmailAddress());
    }

    private Response getResponse(){
        return sessionVariableCalled("response");
    }

    private Map getBodyResponse(){
        Response response = sessionVariableCalled("response");
        return response.jsonPath().get();
    }

    private ArrayList getArrayResponse(){
        Response response = sessionVariableCalled("response");
        return response.jsonPath().get();
    }

    private SchoolDTO getObjectResponse(){
        Response response = sessionVariableCalled("response");
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(response.jsonPath().get());
        return gson.fromJson(jsonElement, SchoolDTO.class);
    }
}
