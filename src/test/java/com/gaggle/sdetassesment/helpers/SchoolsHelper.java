package com.gaggle.sdetassesment.helpers;

import com.gaggle.sdetassesment.dtos.RequestData;
import com.gaggle.sdetassesment.dtos.SchoolDTO;
import com.gaggle.sdetassesment.utils.ConfigureProperties;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

public class SchoolsHelper extends BaseRequest{
    public void setRequestData(){
        String baseUri = ConfigureProperties.getProperty("URL");
        String basePath = ConfigureProperties.getProperty(sessionVariableCalled("api"));

        RequestData requestData = RequestData
                .builder()
                .baseUri(baseUri)
                .basePath(basePath)
                .build();

        setSessionVariable("requestData").to(requestData);
    }

    public void callApi(){
        String api = sessionVariableCalled("api");
        Response response = null;
        switch(api){
            case "GET_ALL_SCHOOLS":
                response = getAllSchools();
                break;
            case "GET_SPECIFIC_SCHOOL":
                response = getSpecificSchool();
                break;
            case "ADD_SCHOOL":
                setSchoolDto();
                response = addSchool();
                break;
            case "UPDATE_SCHOOL":
                response = updateSchool();
                break;
        }

        setSessionVariable("response").to(response);
    }

    public SchoolDTO setSchoolDto(){
        DataTable dataTable = sessionVariableCalled("datatable");
        List<Map<String,String>> schoolInfo = dataTable.asMaps();

        SchoolDTO schoolDTO = new SchoolDTO();
        schoolDTO.setSchoolId(Integer.parseInt(schoolInfo.get(0).get("schoolId")));
        schoolDTO.setSchoolName(schoolInfo.get(0).get("schoolName"));
        schoolDTO.setStudentCount(Integer.parseInt(schoolInfo.get(0).get("studentCount")));
        schoolDTO.setEmailAddress(schoolInfo.get(0).get("emailAddress"));

        setSessionVariable("schoolDTO").to(schoolDTO);
        return schoolDTO;
    }

    private Response getAllSchools(){
        return getRequest(getRequestData());
    }

    private Response getSpecificSchool(){
        RequestData requestData = getRequestData();
        int id = sessionVariableCalled("id");
        requestData.setBasePath(String.format(requestData.getBasePath(),id));
        return getRequest(requestData);
    }

    private Response addSchool(){
        return putRequest(getRequestData(),setSchoolDto());
    }

    private Response updateSchool(){
        RequestData requestData = getRequestData();
        int id = sessionVariableCalled("id");
        requestData.setBasePath(String.format(requestData.getBasePath(),id));
        return postRequest(getRequestData(),setSchoolDto());
    }

    private RequestData getRequestData(){
        return sessionVariableCalled("requestData");
    }
}
