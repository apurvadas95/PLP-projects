package com.flightdetails.a8113.springbootflight.controller;

import com.flightdetails.a8113.springbootflight.model.Flight;
import com.flightdetails.a8113.springbootflight.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.flightdetails.a8113.springbootflight.dao.Dao;

import java.sql.SQLException;
import java.util.List;


@Controller
public class ControllerClass {

    public static final Logger logger = LoggerFactory.getLogger(ControllerClass.class);


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    ControllerClass(JdbcTemplate jdbcTemplt){
        this.jdbcTemplate=jdbcTemplt;

    }
    @RequestMapping("/testConnection")
    @ResponseBody
    public boolean canConnectToDB() {
        boolean result;
        try {
            jdbcTemplate.getDataSource().getConnection();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @RequestMapping(value="/Users",method= RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User getUser(@RequestBody User user) throws SQLException, ClassNotFoundException {

      //  user.setName(user.getName());
        //User user=new User();
        String name = user.getName();

        System.out.print(name);

        Dao dao=new Dao(jdbcTemplate);
        dao.setUserDetails(user);
        return user;
    }

    @RequestMapping(value="/Flights",method= RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Flight getFlight(@RequestBody Flight flight) throws SQLException, ClassNotFoundException {

        //  user.setName(user.getName());
        //User user=new User();
        int flightNo = flight.getFlightNo();

        System.out.print(flightNo);

        Dao dao=new Dao(jdbcTemplate);
        dao.setFlightDetails(flight);
        return flight;
    }

    @RequestMapping(value="/getUsers",method= RequestMethod.GET, consumes = "application/json")
    @ResponseBody
    public List<User> getUsers() throws SQLException, ClassNotFoundException {


        Dao dao=new Dao(jdbcTemplate);
       List<User> users= dao.getUserDetails();
       return users;


    }

    @RequestMapping(value="/getFlights",method= RequestMethod.GET, consumes = "application/json")
    @ResponseBody
    public List<Flight> getFlights() throws SQLException, ClassNotFoundException {


        Dao dao=new Dao(jdbcTemplate);
        List<Flight> flights= dao.getFlightDetails();
        return flights;


    }
    @RequestMapping(value="/getFlightBookings/{ticketNo}",method= RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getFlightBookings(@PathVariable int ticketNo) throws SQLException, ClassNotFoundException {
        logger.info("Fetching User with ticketNo {}", ticketNo);

        Dao dao=new Dao(jdbcTemplate);
        User userFlights= dao.getFlightBookingDetails(ticketNo);
        if (userFlights == null) {
            logger.error("User with ticketNo {} not found.", ticketNo);
            return new ResponseEntity(new CustomErrorType("User with this ticket " + ticketNo
                    + " not found"), HttpStatus.NOT_FOUND);

    }

        return new ResponseEntity<User>(userFlights, HttpStatus.OK);

}}
