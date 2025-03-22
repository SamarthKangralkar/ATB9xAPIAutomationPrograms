package org.example.ex02_RestAssuredBasics.Put;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITestNonBDDStyle {
    @Test
    public void TestAPI(){
        String bookingid="2547";
        String token="834b12c5dcfe992";
        String payload="{\n" +
                "    \"firstname\" : \"Varsha\",\n" +
                "    \"lastname\" : \"K\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification rs = RestAssured.given();
       // rs.headers("Authorization", "Basic  YWRtaW46cGFzc3dvcmQxMjM");
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload);


        Response response= rs.when().log().all().put();

        ValidatableResponse vr = response.then().log().all().statusCode(200);




    }
}
