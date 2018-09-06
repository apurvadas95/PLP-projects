package com.demo.plp.model;

import com.demo.plp.entity.Bookings;

import javax.persistence.*;


public class BookingsModel {

    private int ticketNo;
    private String emailId;
    private int status;
    private String name;
    private int age;
    private FlightsModel flights;

    public BookingsModel(){

    }

    public BookingsModel(Bookings bookings){

        this.age=bookings.getAge();
        this.emailId=bookings.getEmailId();
        this.name=bookings.getName();
        this.status=bookings.getStatus();
        this.ticketNo=bookings.getTicketNo();
        this.flights=new FlightsModel(bookings.getFlights());
    }
    public FlightsModel getFlights() {
        return flights;
    }

    public void setFlights(FlightsModel flights) {
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

   /* public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }*/


}
