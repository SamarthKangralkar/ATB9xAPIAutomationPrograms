package org.example.ex02_RestAssuredBasics.Post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITestingBDDStyle {

        @Test
        public void TestBDD(){
            String payload="{\n" +
                    "    \"username\" : \"admin\",\n" +
                    "    \"password\" : \"password123\"\n" +
                    "}";

            RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .log().all().body(payload)
                    .contentType(ContentType.JSON)
                    .when().log().all().post()
                    .then().log().all().statusCode(200);


        }
    }

