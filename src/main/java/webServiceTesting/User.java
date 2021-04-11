package webServiceTesting;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class User {
    protected RequestSpecification requestSpecification;
    protected ExtractableResponse<Response> response;

    public int getResponseCode() {
            return response.statusCode();
    }
}