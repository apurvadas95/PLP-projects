package com.flightdetails.a8113.springbootflight.model;


import java.sql.Time;

public class Flight {

    private int flightNo;
    private  String origin;
    private  String destination;
    private  String date;
    private Time time;
    private int flightId;
    private  int ticketNo;

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    //    public JsonArrayFormatVisitor[] getFlightId() {
//        return flightId;
//    }
//
//    public void setFlightId(JsonArrayFormatVisitor[] flightId) {
//        this.flightId = flightId;
//    }

        public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
