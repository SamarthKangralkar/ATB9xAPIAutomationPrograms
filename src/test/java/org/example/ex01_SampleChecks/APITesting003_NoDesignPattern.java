package org.example.ex01_SampleChecks;

import io.restassured.RestAssured;

public class APITesting003_NoDesignPattern {
    public void step1(){
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/booking/")
                .when()
                .get()
                .then().log().all().statusCode(200);

    }
    public void step2(){

    }
    public void step3(String param1){

    }

    public static void main(String[] args) {
        APITesting003_NoDesignPattern np = new APITesting003_NoDesignPattern();
        np.step1();
        np.step2();
        np.step3("samarth");
    }
}
