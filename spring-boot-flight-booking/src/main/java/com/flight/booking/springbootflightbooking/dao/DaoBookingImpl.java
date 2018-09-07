package com.flight.booking.springbootflightbooking.dao;
import com.flight.booking.springbootflightbooking.model.Flight;
import com.flight.booking.springbootflightbooking.model.FlightBooking;
import com.flight.booking.springbootflightbooking.model.GetFlightBooking;
import com.flight.booking.springbootflightbooking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@Repository
public class DaoBookingImpl  implements DaoBookingInterface {

    @Autowired
    JdbcTemplate jdbcTemplate;

    int id=0;


    public void getUserDetails() {


        String sql = "select * from UserDetails where id in(select max(id) from userdetails);";
        List<Flight> flights = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Flight.class));


        for(Flight flight: flights){
            id=flight.getId();
        }
    }


    public String setUserDetails(FlightBooking fB) {

        String emailId = fB.getUser().getEmailId();
        String name = fB.getUser().getName();
        String gender = fB.getUser().getGender();
        int age =fB.getUser().getAge();
        int ticketNo = fB.getUser().getTicketNo();
        String message="Details Saved";


        try{
            KeyHolder keyHolder= new GeneratedKeyHolder();
            String sqlUser = "INSERT INTO UserDetails  VALUES (?,?,?,?,default,?) RETURNING id";
            jdbcTemplate.update(sqlUser,keyHolder,new Object[]{emailId,
                     gender, age, name, ticketNo
            });
        Flight flight=new Flight();
        flight.setId(keyHolder.getKey().intValue());

        int uniqueId=flight.getId();
           System.out.print(uniqueId);
           /* for(Flight flight: flights){
                id=flight.getId();
            }*/
        }

        catch (Exception ex){

            //message=ex.toString();
            message="Ticket Number already Exists!!";

        }

        return message;

    }

    public void setFlightDetails(FlightBooking fB) {

        List<Flight> flights=fB.getFlights();

        for (Flight flight:flights) {

            int flightNo = flight.getFlightNo();
            String date = flight.getDate();
            Time time = flight.getTime();
            String origin = flight.getOrigin();
            String destination = flight.getDestination();

            try {
                String sqlFlight = "INSERT INTO FlightDetails " + "(flightNo, date, time,origin,destination,id) VALUES (?,?,?,?,?,?)";

                jdbcTemplate.update(sqlFlight, new Object[]{flightNo,
                        date, time, origin, destination, id
                });
            }
            catch(Exception ex){
                ex.printStackTrace();
            }

        }

    }

    public FlightBooking getFlightBookingDetails(int ticketNo) {

        List<Flight> flights= new ArrayList<>();
        FlightBooking flightBooking=new FlightBooking();
      String sqlUser="select * from userdetails inner join flightdetails on userdetails.id=flightdetails.id where userdetails.ticketno=?;";
      List<GetFlightBooking> users = jdbcTemplate.query(sqlUser, new Object[]{ticketNo}, new BeanPropertyRowMapper(GetFlightBooking.class));


        for(GetFlightBooking getFlightBooking:users){

            User  user=new User();

            user.setAge(getFlightBooking.getAge());
            user.setEmailId(getFlightBooking.getEmailId());
            user.setGender(getFlightBooking.getGender());
            user.setTicketNo(getFlightBooking.getTicketNo());
            user.setName(getFlightBooking.getName());

            flightBooking.setUser(user);

            Flight flight=new Flight();

            flight.setTime(getFlightBooking.getTime());
            flight.setOrigin(getFlightBooking.getOrigin());
            flight.setId(getFlightBooking.getId());
            flight.setFlightNo(getFlightBooking.getFlightNo());
            flight.setDestination(getFlightBooking.getDestination());
            flight.setDate(getFlightBooking.getDate());

            flights.add(flight);

            flightBooking.setFlights(flights);

        }

        return flightBooking;
    }

}





















//
//        JSONArray json=new JSONArray();
//        FlightBooking setBooking=new FlightBooking();
//
//        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray1 = new JSONArray();
//
//        JSONObject jsonObject1 = new JSONObject();
//        JSONArray jsonArray2 = new JSONArray();
//        String message="Invalid Ticket No";
//        JSONObject error=new JSONObject();
//        error.put("ERROR",message);
//        JSONArray errorMessage=new JSONArray();
//        errorMessage.add(0,error);
//
//        for (GetFlightBooking user : users) {
//
//            JSONObject jsonObjectUser = new JSONObject();
//
//            int index1 = 0;
//            String name = user.getName();
//            String emailId = user.getEmailId();
//            int age = user.getAge();
//            String gender = user.getGender();
//            ticketNo = user.getTicketNo();
////
////            int flightNo = user.getFlightNo();
////            String date = user.getDate();
////            Time time = user.getTime();
////            String origin = user.getOrigin();
////            String destination = user.getDestination();
//
//
//
//            setBooking.getUser().setName(name);
//            setBooking.getUser().setTicketNo(ticketNo);
//            setBooking.getUser().setGender(gender);
//            setBooking.getUser().setEmailId(emailId);
//            setBooking.getUser().setAge(age);
//
//
//
////
////
////            jsonObjectUser.put("name", name);
////            jsonObjectUser.put("emailId", emailId);
////            jsonObjectUser.put("age", age);
////            jsonObjectUser.put("gender", gender);
////            jsonObjectUser.put("ticketNo", ticketNo);
//
//            jsonArray1.add(jsonObjectUser);
//
//            jsonObject.put("USER DETAILS", jsonArray1);
//
//            json.add(jsonObject);
//            }
//
//            for (GetFlightBooking flight : users) {
//
//                JSONObject jsonObjectFlight = new JSONObject();
//
//                List<Flight> flights;
//                int index2 = 0;
//
//                int flightNo = flight.getFlightNo();
//                String date = flight.getDate();
//                Time time = flight.getTime();
//                String origin = flight.getOrigin();
//                String destination = flight.getDestination();
//               int id = flight.getId();
//
//

//
//                jsonObjectFlight.put("flightNo", flightNo);
//                jsonObjectFlight.put("date", date);
//                jsonObjectFlight.put("time", time);
//                jsonObjectFlight.put("origin", origin);
//                jsonObjectFlight.put("destination", destination);
               // jsonObjectFlight.put("fid", flightId);

//                jsonArray2.add(jsonObjectFlight);
//
//
//                jsonObject1.put("FLIGHTS", jsonArray2);
//            }
//                json.add(jsonObject1);

//        if (json.size()==1) {
//
//            return errorMessage;}
//            else{
//            return json;
//      }

////    public List<Flight> getMulFlights(int ticketNo) {
////        String sql="select*from flightdetails where ticketno=?;";
////        List<Flight> flights = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Flight.class), new Object[]{ticketNo});
////
////        return flights;



