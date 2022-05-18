package com.gaggle.sdetassesment.helpers;

import com.gaggle.sdetassesment.dtos.RequestData;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static net.serenitybdd.rest.SerenityRest.given;

public class BaseRequest {

    public <V> Response postRequest(RequestData requestData, V body) {
        return prepareRequest(requestData)
                .body(body)
                .when()
                .post();
    }

    public Response getRequest(RequestData requestData) {
        return prepareRequest(requestData)
                .when()
                .get();
    }

    public <V> Response putRequest(RequestData requestData, V body) {
        return prepareRequest(requestData)
                .body(body)
                .when()
                .put();
    }

    public RequestSpecification prepareRequest(RequestData requestData){
        RequestSpecification requestSpecification = given().log().all();
        requestSpecification
                .contentType("application/json")
                .baseUri(requestData.getBaseUri())
                .basePath(requestData.getBasePath());

        return requestSpecification;
    }
}