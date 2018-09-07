package com.flight.booking.springbootflightbooking.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flight.booking.springbootflightbooking.dao.DaoBookingImpl;
import com.flight.booking.springbootflightbooking.dao.DaoBookingInterface;
import com.flight.booking.springbootflightbooking.model.FlightBooking;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ServiceBookingImpl implements ServiceBookingInterface {


    @Autowired
    DaoBookingInterface daoBookingInterface;


    @Override
    public JSONObject saveUserDetails(FlightBooking fB) {

        String emailId = fB.getUser().getEmailId();
        int ticketNo = fB.getUser().getTicketNo();
        JSONObject jsonObject=new JSONObject();

        String json= daoBookingInterface.setUserDetails(fB);
        daoBookingInterface.getUserDetails();
        daoBookingInterface.setFlightDetails(fB);
        String error = "Ticket number or Email Id Missing";



        if(ticketNo==0 || emailId==null){
            jsonObject.put("Error Message",error);

        }
         else{

        jsonObject.put("Error Message",json);}

        return jsonObject;

    }

    @Override
    public FlightBooking getUserDetails(int ticketNo) throws JsonProcessingException {


        FlightBooking json= daoBookingInterface.getFlightBookingDetails(ticketNo);
       /* ObjectMapper objectMapper=new ObjectMapper();
        String jsonString=objectMapper.writeValueAsString(json);
*/
        return json ;
    }
}
