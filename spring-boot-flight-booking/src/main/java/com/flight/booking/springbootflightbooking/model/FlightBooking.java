package com.flight.booking.springbootflightbooking.model;

import java.util.ArrayList;
import java.util.List;

public class FlightBooking {

    User user= new User();
    List<Flight> flights=new ArrayList<Flight>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
