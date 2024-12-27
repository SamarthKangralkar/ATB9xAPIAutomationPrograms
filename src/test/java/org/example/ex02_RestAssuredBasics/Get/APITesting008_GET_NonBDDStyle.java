package org.example.ex02_RestAssuredBasics.Get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting008_GET_NonBDDStyle {
    public static void main(String[] args) {
    APITesting008_GET_NonBDDStyle np = new APITesting008_GET_NonBDDStyle();
    np.Test_PositiveNonBDD();

    }


    @Test
        public void Test_PositiveNonBDD () {

            String pincode = "590006";
            RequestSpecification r = RestAssured.given();
            r.baseUri("https://api.zippopotam.us");
            r.basePath("/IN/" + pincode);

            Response response = r.when().log().all().get();

            ValidatableResponse vr = response.then().log().all().statusCode(200);

        }

    }
