package org.example.ex01_SampleChecks;

import io.restassured.RestAssured;

public class APITesting002 {
    public static void main(String[] args) {
        //Gherkin Syntax
        //Given() pre req URL Headers Auth Body
        //When() HHTp Methods Get Post Put
        //Then()  Validation

        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us/")
                    .basePath("/IN/590006")
                .when()
                    .get()
                .then()
                .log().all().statusCode(200); // It Will Print the output in json format

    }
}
