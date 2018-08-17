package com.groupkt.services.api;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

/**
 * @author amasthipur
 * Created on : 8/16/18
 */
public class GetStateServiceImpl implements GetStateService {

    String basePath;

    private void setContentType (ContentType Type){
        given().contentType(Type);
    }

    public GetStateServiceImpl(String basePath) {
        this.basePath = basePath;
    }

    public Response getAllStatesByCountry() {
        setContentType(ContentType.JSON);
        return get(basePath);
    }
}
