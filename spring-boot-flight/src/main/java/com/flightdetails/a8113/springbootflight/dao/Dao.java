package com.flightdetails.a8113.springbootflight.dao;

import com.flightdetails.a8113.springbootflight.model.Flight;
import com.flightdetails.a8113.springbootflight.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.List;


public class Dao {

    private final JdbcTemplate jdbcTemplate;
    private static List<User> users;

    @Autowired
    public Dao(JdbcTemplate jTemplate){


           this.jdbcTemplate = jTemplate;


    }


    public List<Flight> getFlightDetails() {

        String sql = "select * from FlightDetails";
        List<Flight> flights = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Flight.class));

        return flights;
    }

    public List<User> getUserDetails() {


            String sql = "select * from UserDetails";
            List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));

            return users;
    }


    public void setUserDetails(User user) throws SQLException, ClassNotFoundException {

        String emailId = user.getEmailId();
        String name = user.getName();
        String gender = user.getGender();
        int age = user.getAge();
        int ticketNo = user.getTicketNo();


try{
        String sqlUser = "INSERT INTO UserDetails " + "(emailId,name,gender,age,ticketNo) VALUES (?,?,?,?,?,)";

        //jdbcTemplate = new JdbcTemplate(dataSource);
//jdbcTemplate.getDataSource().getConnection();
    jdbcTemplate.update(sqlUser, new Object[]{emailId,
                name, gender, age, ticketNo
        });
    }
    catch (Exception ex){

    ex.printStackTrace();
    System.out.print("Caught Exception");
    }
}
    public void setFlightDetails(Flight flight) throws SQLException, ClassNotFoundException {
        // private DataSource dataSource;
//    private JdbcTemplate jdbcTemplate;
//
        int flightNo = flight.getFlightNo();
        String date = flight.getDate();
        Time time = flight.getTime();
        String origin = flight.getOrigin();
        String destination = flight.getDestination();
        int flightId=flight.getFlightId();
        int ticketNo=flight.getTicketNo();

        try {

            String sqlFlight = "INSERT INTO FlightDetails " + "(flightNo, date, time,origin,destination,flightId,ticketNo) VALUES (?,?,?,?,?,?,?)";

//        jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(sqlFlight, new Object[]{flightNo,
                    date, time, origin, destination,flightId,ticketNo
            });
        }
        catch(Exception e){
            e.printStackTrace();
        }
}

    public User getFlightBookingDetails(int ticketNo) {

            String sql = "select *from userdetails INNER JOIN flightdetails ON userdetails.ticketNo =flightdetails.ticketNo where userdetails.ticketNo=?";
            jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class), new Object[]{ticketNo});
for(User user:users){
    if(user.getTicketNo() == ticketNo){
            return  user;
    }
}
return  null;
    }}
