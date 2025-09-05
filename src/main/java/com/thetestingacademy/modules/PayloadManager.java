package com.thetestingacademy.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.thetestingacademy.pojos.requestPOJO.Auth;
import com.thetestingacademy.pojos.requestPOJO.Booking;
import com.thetestingacademy.pojos.requestPOJO.BookingDates;
import com.thetestingacademy.pojos.requestPOJO.LoginRequest;
import com.thetestingacademy.pojos.responsePOJO.BookingResponse;
import com.thetestingacademy.pojos.responsePOJO.InvalidTokenResponse;
import com.thetestingacademy.pojos.responsePOJO.LoginResponse;
import com.thetestingacademy.pojos.responsePOJO.TokenResponse;

public class PayloadManager {
  Gson gson;
  Faker faker;

  //Convert the java object into JSON  String to use the payload
  //Serialization
  public String createPayloadBookingAsString(){
      Booking booking = new Booking();
      booking.setFirstname("Pramod");
      booking.setLastname("Dutta");
      booking.setTotalprice(112);
      booking.setDepositpaid(true);

      BookingDates bookingDates = new BookingDates();
      bookingDates.setCheckin("2024-02-01");
      bookingDates.setCheckout("2024-02-01");
      booking.setBookingdates(bookingDates);
      booking.setAdditionalneeds("Breakfast");

      System.out.println(booking);

      //Java Object to JSON
      gson = new Gson();
      String jsonStingBooking = gson.toJson(booking);
      return jsonStingBooking;
  }

    public String createPayloadBookingAsStringWrongBody(){
        Booking booking = new Booking();
        booking.setFirstname("会意; 會意");
        booking.setLastname("会意; 會意");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("5025-02-01");
        bookingDates.setCheckout("5025-02-01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("会意; 會意");

        System.out.println(booking);

        //Java Object to JSON
        gson = new Gson();
        String jsonStingBooking = gson.toJson(booking);
        return jsonStingBooking;
    }
    //Convert the JSON String to Java Object so that we can verify response Body
    //Deserialization
    public BookingResponse bookingResponseJava(String responseString){
      gson = new Gson();
      BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
              return bookingResponse;
    }

    public Booking getResponseFromJSON(String responseString){
        gson = new Gson();
        Booking bookingResponse = gson.fromJson(responseString, Booking.class);
        return bookingResponse;
    }
    public String createPayloadBookingFakerJS(){
      faker = new Faker();
        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1,1000));
        booking.setDepositpaid(faker.random().nextBoolean());

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        //Java Object to JSON
        gson = new Gson();
        String jsonStingBooking = gson.toJson(booking);
        return jsonStingBooking;
    }

    public String fullUpdatePayloadAsString(){
        Booking booking = new Booking();
        booking.setFirstname("Lucky");
        booking.setLastname("Dutta");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);
    }

    //Java Object -> JSON
    public String setAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        gson = new Gson();
        String jsonpayloadString = gson.toJson(auth);
        System.out.println("Payload set to the -> " +jsonpayloadString);
        return jsonpayloadString;
    }

    //DeSer (JSON String -> Java Object)
    public String getTokenFromJSON(String tokenResponse){
      gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse,TokenResponse.class);
        return tokenResponse1.getToken();

    }
    //DeSer (JSON String -> Java Object)
    public String getInvalidResponse(String invalidTokenResponse){
        gson = new Gson();
        InvalidTokenResponse tokenResponse1 = gson.fromJson(invalidTokenResponse, InvalidTokenResponse.class);
        return tokenResponse1.getReason();

    }

    //Java Object -> JSON
    public String setLoginData(){
       LoginRequest loginRequest = new LoginRequest();
       loginRequest.setUsername("contact+aug@thetestingacademy.com");
       loginRequest.setPassword("TtxkgQ!s$rJBk85");
       loginRequest.setRemember(false);
       loginRequest.setRecaptchaResponseField("");

        gson = new Gson();
        String jsonpayloadString = gson.toJson(loginRequest);
        System.out.println("Payload Login  to the -> " +jsonpayloadString);
        return jsonpayloadString;
    }

    //DeSer (JSON String -> Java Object)
    public LoginResponse getLoginData(String loginResponseEx){
        gson = new Gson();
        LoginResponse loginResponse = gson.fromJson(loginResponseEx, LoginResponse.class);
        return loginResponse;

    }

}