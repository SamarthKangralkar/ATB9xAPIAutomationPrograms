package org.example.ex02_RestAssuredBasics.Patch;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITestPatch {
    @Test
    public void APITestPatch(){

        String  payload="{\n" +
                "    \"firstname\" : \"sam\",\n" +
                "    \"lastname\" : \"zRT\"\n" +
                "}";
        String bookingid="4156";
        String token="276a346d9cb8e13";

        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingid);
        rs.body(payload);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);

        Response response = rs.when().log().all().patch();

        ValidatableResponse vr = response.then().log().all().statusCode(200);




    }


}
