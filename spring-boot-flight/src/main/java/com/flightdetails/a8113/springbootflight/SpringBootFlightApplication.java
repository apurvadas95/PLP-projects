package com.flightdetails.a8113.springbootflight;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.flightdetails.a8113.springbootflight"})
public class SpringBootFlightApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFlightApplication.class, args);
    }
}
