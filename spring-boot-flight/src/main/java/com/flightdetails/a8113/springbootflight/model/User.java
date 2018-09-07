package com.flightdetails.a8113.springbootflight.model;


import java.util.List;

public class User {

    private String emailId;
    private String name;
    private String gender;
    private int age;
    private  int ticketNo;
    private List<Flight> flights;

//    @Override
//    public JsonArrayFormatVisitor[] getFlightId() {
//        return flightId;
//    }
//
//    @Override
//    public void setFlightId(JsonArrayFormatVisitor[] flightId) {
//        this.flightId = flightId;
//    }
//    Flight flights= new Flight();
//
//
//    public Flight getFlights() {
//        return flights;
//    }
//
//    public void setFlights(Flight flights) {
//        this.flights = flights;
//    }

//    public int getFlightId() {
//        return flightId;
//    }
//
//    public void setFlightId(int flightId) {
//        this.flightId = flightId;
//    }


    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
