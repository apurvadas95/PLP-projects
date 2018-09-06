package com.demo.plp.entity;

import com.demo.plp.model.FlightsModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


@Entity
@Table(name = "Flights")
public class Flights {

    @Id
    @Column(name="flightNo")
    private int flightNo;

    @Column(name="source")
    private String source;

    @Column(name="destination")
    private String destination;

    @Column(name="time")
    private String time;

    @Column(name="duration")
    private  float duration;

   /* @Column(name="price")
    private  float price;*/


    @DateTimeFormat(pattern = "yyyy-MM-dd")
     @Column(name = "date")
     private long date;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }


     /*  public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }*/
/*
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }*/

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

    public Flights(FlightsModel flightsModel ) {

        this.flightNo = flightsModel.getFlightNo();
        this.source =  flightsModel.getSource();
        this.destination =  flightsModel.getDestination();
        this.duration =  flightsModel.getDuration();
        if (null != flightsModel.getDate()) {
            this.date =  flightsModel.getDate().getTime();
        }
    }

    public Flights() {

    }

}
