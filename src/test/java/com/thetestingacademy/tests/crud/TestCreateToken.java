package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @TmsLink("https://bugz.atlassian.net/browse/TS-1")
    @Owner("Bhagyalakshmi-patil")
    @Description("TC#1 - Create Token and verify")
    public void testTokenPost(){
     requestSpecification.basePath(APIConstants.Auth_URL);
     response = RestAssured.given(requestSpecification).when().body(payloadManager.setAuthPayload()).post();

     //Extraction (JSON String Response to Java Object)
        String token = payloadManager.getTokenFromJSON(response.asString());
        System.out.println(token);

        //Validations of the Request
        assertActions.verifyStringKeyNotNull(token);
    }

    @Test(groups = "reg", priority = 1)
    @TmsLink("https://bugz.atlassian.net/browse/TS-1")
    @Owner("Bhagyalakshmi-patil")
    @Description("TC#2 - Create invalid Token and verify")
    public void testTokenPost_Negative(){
        requestSpecification.basePath(APIConstants.Auth_URL);
        response = RestAssured.given(requestSpecification).when().body("{}").post();

        //Extraction (JSON String Response to Java Object)
        String invalid_reason = payloadManager.getInvalidResponse(response.asString());
        System.out.println(invalid_reason);

        //Validations of the Request
        assertActions.verifyStringKey(invalid_reason,"Bad credentials");
    }
}
