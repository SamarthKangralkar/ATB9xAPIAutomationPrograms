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

public class ex05_payload_pojo {
    ValidatableResponse validatableResponse;

    @Description("RestAssured Asserations")
    @Test
    public void rest_assured_asserations() {

        Booking booking = new Booking();
        booking.setFirstname("Samarth");
        booking.setLastname("Kangralkar");
booking.setTotalprice(881);
booking.setDepositpaid(true);

Bookingdates bookingdates = new Bookingdates();
bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-03-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");


        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(booking).log().all();

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