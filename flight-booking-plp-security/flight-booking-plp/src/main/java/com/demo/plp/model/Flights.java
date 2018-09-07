package com.demo.plp.model;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


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

     @DateTimeFormat(pattern = "yyyy-MM-dd")
     @Column(name = "date")
     private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
