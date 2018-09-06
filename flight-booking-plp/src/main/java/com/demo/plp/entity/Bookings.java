package com.demo.plp.entity;

import com.demo.plp.model.BookingsModel;

import javax.persistence.*;

@Entity
@Table(name = "Bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticketNo")
    private int ticketNo;

    @Column(name = "emailId")
    private String emailId;


   // @Column(name = "flightNo", insertable = false,updatable = false)
   // private int flightNo;

    @Column(name = "status")
    private int status;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flightNo")
    private Flights flights;

    public Flights getFlights() {
        return flights;
    }

    public void setFlights(Flights flights) {
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

    public Bookings() {

    }

    public Bookings(BookingsModel bookingsModel){

        this.age=bookingsModel.getAge();
        this.emailId=bookingsModel.getEmailId();
        this.name=bookingsModel.getName();
        this.status=bookingsModel.getStatus();
        this.ticketNo=bookingsModel.getTicketNo();
        this.flights=new Flights(bookingsModel.getFlights());


    }
}
