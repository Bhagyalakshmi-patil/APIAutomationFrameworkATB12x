package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.responsePOJO.BookingResponse;
import com.thetestingacademy.pojos.responsePOJO.LoginResponse;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestVWOLogin extends BaseTest {


    @Test
    public void test_VWO_Login_Positive() {

        //Set up will run first
        requestSpecification.baseUri(APIConstants.APP_VWO_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.setLoginData()).log().all().post();

       // LoginResponse loginResponse = payloadManager.getLoginData(response.asString());

        //Verification part
        assertActions.verifyStatusCode(response, 401);
      //  System.out.println(loginResponse.getAccountId());
//        assertActions.verifyStringKeyNotNull(loginResponse.getAccountId());
//        assertActions.verifyStringKey(loginResponse.getName(),"Aman");
    }
}
