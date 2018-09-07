package com.flight.booking.springbootflightbooking.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.flight.booking.springbootflightbooking.model.FlightBooking;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface ServiceBookingInterface {

    JSONObject saveUserDetails(FlightBooking fB);
    FlightBooking getUserDetails(int ticketNo) throws JsonProcessingException;

}
