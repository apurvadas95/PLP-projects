package com.flight.booking.springbootflightbooking.dao;

import com.flight.booking.springbootflightbooking.model.FlightBooking;


public interface DaoBookingInterface {

     void getUserDetails();
     String setUserDetails(FlightBooking fB);
     void setFlightDetails(FlightBooking fB);
     FlightBooking getFlightBookingDetails(int ticketNo);

}
