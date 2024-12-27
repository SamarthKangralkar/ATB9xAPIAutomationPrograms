package org.example.ex02_RestAssuredBasics.Get;

import io.restassured.RestAssured;

public class APITesting0006GET_BDDStyle {
    public static void main(String[] args) {
        String pincode="590006";
        RestAssured.given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().get()
                .then().statusCode(200);

        pincode="-1";
        RestAssured.given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().get()
                .then().statusCode(404);
    }
}
