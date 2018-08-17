package com.groupkt.services.api;

import com.jayway.restassured.response.Response;

/**
 * @author amasthipur
 * Created on : 8/16/18
 */
public interface GetStateService {

    public Response getAllStatesByCountry();

}
