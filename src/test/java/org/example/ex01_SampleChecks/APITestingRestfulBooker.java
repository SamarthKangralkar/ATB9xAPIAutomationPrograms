package org.example.ex01_SampleChecks;

import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITestingRestfulBooker {


        public void getBooking() {
            RestAssured.given().baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("/booking/")
                    .when()
                    .get()
                    .then().log().all().statusCode(200);


        }
        public void createBooking(){
            RestAssured.given().baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("/booking/")
                    .when()
                    .post()
                    .then().log().all().statusCode(200);



        }

    public static void main(String[] args) {
        APITestingRestfulBooker rst = new APITestingRestfulBooker();
        rst.createBooking();
    }
    }
