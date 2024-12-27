package org.example.ex02_RestAssuredBasics.Get;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting007_GET_BDDStyle {
    @Test
    public void test_GET_Req(){
        String pincode="590006";
        RestAssured.given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().get()
                .then().statusCode(200);

    }

}
