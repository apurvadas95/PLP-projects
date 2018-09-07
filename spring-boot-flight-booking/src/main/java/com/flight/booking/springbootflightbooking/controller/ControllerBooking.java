package com.flight.booking.springbootflightbooking.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.flight.booking.springbootflightbooking.model.FlightBooking;
import com.flight.booking.springbootflightbooking.service.ServiceBookingInterface;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerBooking {


    @Autowired
    ServiceBookingInterface service;



    @RequestMapping(value="/Users",method= RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public JSONObject setUser(@RequestBody FlightBooking fB) {

       JSONObject json= service.saveUserDetails(fB);

              return json;
    }


    @RequestMapping(value="/getFlightBookings/{ticketNo}",method= RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public FlightBooking getFlightBookings(@PathVariable int ticketNo) throws JsonProcessingException {


            FlightBooking jsonString = service.getUserDetails(ticketNo);
            return jsonString;

    }

}








































//    @RequestMapping("/testConnection")
//    @ResponseBody
//    public boolean canConnectToDB() {
//        boolean result;
//        try {
//            jdbcTemplate.getDataSource().getConnection();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            result = false;
//        }
//        return result;
//    }

