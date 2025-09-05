package com.thetestingacademy.asserts;

import io.restassured.response.Response;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertActions {
    public void verifyResponseBody(String actual,String expected,String description){
        assertEquals(actual,expected,description);
    }
    public void verifyResponseBody(int actual,int expected,String description){
        assertEquals(actual,expected,description);
    }
    public void verifyStatusCode(Response response,Integer expected){
        assertEquals(response.getStatusCode(),expected);
    }
    public void verifyStringKey(String keyExpect,String KeyActual){
        //AssertJ
        assertThat(keyExpect).isNotNull();
        assertThat(keyExpect).isNotBlank();
        assertThat(keyExpect).isEqualTo(KeyActual);
    }
    public void verifyStringKeyNotNull(Integer keyExpect){
        //AssertJ
        assertThat(keyExpect).isNotNull();
    }
    public void verifyStringKeyNotNull(String  keyExpect){
        //AssertJ
        assertThat(keyExpect).isNotNull();
    }

    public void verifyTrue(boolean  keyExpect){
        //AssertJ
        assertTrue(keyExpect);
    }

}
