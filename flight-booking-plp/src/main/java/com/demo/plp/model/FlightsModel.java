package com.demo.plp.model;

import com.demo.plp.entity.Flights;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;


public class FlightsModel {

    private int flightNo;
    private String source;
    private String destination;
    private String time;
    private  float duration;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
/*
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/

    public FlightsModel() {

    }

    public FlightsModel(Flights flights) {

        this.flightNo=flights.getFlightNo();
        this.source=flights.getSource();
        this.destination=flights.getDestination();
        this.duration=flights.getDuration();
        this.time=flights.getTime();
        Date date= new Date();
        date.setTime(flights.getDate());
        this.date =  date;

    }
}
