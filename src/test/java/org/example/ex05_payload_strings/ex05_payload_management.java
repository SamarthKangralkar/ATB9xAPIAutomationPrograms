package org.example.ex05_payload_strings;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ex05_payload_management {
    ValidatableResponse validatableResponse;

    @Description("RestAssured Asserations")
    @Test
    public void rest_assured_asserations() {


//        String payload = "{\n" +
//                "    \"firstname\" : \"Samarth\",\n" +
//                "    \"lastname\" : \"Kangralkar\",\n" +
//                "    \"totalprice\" : 881,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";
                //MAP -> JSON (GSON,JACKSON)
        Map<String,Object> mp = new LinkedHashMap<>();
        mp.put("firstname","Samarth");
        mp.put("lastname","Kangralkar");
        mp.put("totalprice","881");
        mp.put("depositpaid","true");

        Map<String,Object> bookingdates = new LinkedHashMap<>();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        mp.put("bookingdates",bookingdates);
        mp.put("additionalneeds","Breakfast");


        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(mp).log().all();

        Response response = rs.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname", Matchers.equalTo("Samarth"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));


        //TESTNG ASSERATIONS

        int bookingid = response.then().log().all().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        Assert.assertNotNull(bookingid);
        Assert.assertEquals(firstname, "Samarth");
        Assert.assertEquals(lastname, "Kangralkar");


        //ASSERTJ Asserations


        assertThat(bookingid).isNotNull().isNotNegative();
        assertThat(firstname).isNotNull().isAlphanumeric().isNotBlank();

    }
}