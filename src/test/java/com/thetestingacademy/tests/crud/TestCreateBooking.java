package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.modules.PayloadManager;
import com.thetestingacademy.pojos.responsePOJO.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateBooking  extends BaseTest {

 @Test(groups = "reg",priority = 1)
 @Owner("Bhagyalakshmi-patil")
 @Description("TC#1 - Verify that the Booking can be created ")
    public void testCreateBookingPOST_Positive(){
     //Set up will run first
     requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
     response = RestAssured.given(requestSpecification).when().body(payloadManager.
             createPayloadBookingAsString()).log().all().post();
     BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

     //Verification part
     assertActions.verifyStatusCode(response,200);
     assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
     assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Pramod");

    }

    @Test(groups = "reg",priority = 1)
    @Owner("Bhagyalakshmi-patil")
    @Description("TC#1 - Verify that the Booking can't be created, when payload is null ")
    public void testCreateBookingPOST_Negative(){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body("{}").log().all().post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(500);
    }

    @Test(groups = "reg",priority = 1)
    @Owner("Bhagyalakshmi-patil")
    @Description("TC#1 - Verify that the Booking can't be created, when payload is chinese ")
    public void testCreateBookingPOST_Positive_Chinese(){
     requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
     response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingAsStringWrongBody())
             .log().all().post();
     validatableResponse = response.then().log().all();
     validatableResponse.statusCode(200);

     BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
     assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
    }

    @Test(groups = "reg",priority = 1)
    @Owner("Bhagyalakshmi-patil")
    @Description("TC#1 - Verify that the Booking can't be created, when payload is negative ")
    public void testCreateBookingPOST_POSITIVE_FAKER_RANDOM_DATA(){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingFakerJS())
                .log().all().post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBooking().getFirstname());
    }

}
