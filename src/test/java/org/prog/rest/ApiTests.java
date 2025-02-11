package org.prog.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.prog.dto.LocationDto;
import org.prog.dto.ResultsDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {

    @Test
    public void apiTest() {
        RequestSpecification requestSpecification = given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", "1");

        Response response = requestSpecification.get();
        response.prettyPrint();

        ResultsDto results = response.as(ResultsDto.class);
        System.out.println(results.getResults().get(0).getName().getFirst());
        System.out.println(results.getResults().get(0).getName().getLast());

        LocationDto location = results.getResults().get(0).getLocation ();
        System.out.println("Вулиця: " + location.getStreet().getNumber() + " " + location.getStreet().getName());
        System.out.println("Місто: " + location.getCity());
        System.out.println("Штат: " + location.getState());
        System.out.println("Країна: " + location.getCountry());
        System.out.println("Поштовий індекс: " + location.getPostcode());
        System.out.println("Координати: Широта: " + location.getCoordinates().getLatitude() +
                ", Довгота: " + location.getCoordinates().getLongitude());

//        String value = response.jsonPath().get("results[0].gender");
//        System.out.println(value);
//        Assert.assertEquals(value, "female");
//        response.prettyPrint();
//
//        ValidatableResponse validatableResponse = response.then();
//        validatableResponse.statusCode(200);
//        validatableResponse.contentType(ContentType.JSON);
//        validatableResponse.body("results[0].gender", equalTo("male"));


    }
}
