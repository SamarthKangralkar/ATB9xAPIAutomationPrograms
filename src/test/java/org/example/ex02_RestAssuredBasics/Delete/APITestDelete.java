package org.example.ex02_RestAssuredBasics.Delete;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITestDelete {
    @Test
    public void APITest(){
        String bookingid="2784";
        String token="d3cb5d514e335f3";

        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingid);
       rs.contentType(ContentType.JSON);
       rs.cookie("token",token);

        Response response = rs.when().log().all().delete();

        ValidatableResponse vr = response.then().log().all().statusCode(201);

    }
}
