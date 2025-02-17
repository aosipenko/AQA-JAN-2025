package org.prog.homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.notNullValue;

public class RestAssuredTestClass {

    @Test
    public void apiTest() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("inc", "gender, name, nat, location");
        requestSpecification.queryParam("noinfo");
        //requestSpecification.queryParam("results", "1");
        Response response = requestSpecification.get();
        response.prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        System.out.println(response.body());
        validatableResponse.body("results[0].location.city ", notNullValue());

//serialization
//        ResultsDto results = response.as(ResultsDto.class);
//        System.out.println(results.getResults().get(0).getName().getFirst());
//        System.out.println(results.getResults().get(0).getName().getLast());
    }

}
