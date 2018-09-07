/*
package com.flight.booking.springbootflightbooking.controller;


import com.flight.booking.springbootflightbooking.dao.DaoBookingImpl;
import com.flight.booking.springbootflightbooking.model.GetFlightBooking;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DaoBookingImpl.class, secure = false)
public class ControllerClassTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private DaoBookingImpl dao;

   @Mock
   JdbcTemplate jdbcTemplate;

    @Autowired
    public ControllerClassTest(){
        //this.jdbcTemplate=jdbcTemplt;

    }

    //DaoBookingImpl dao1=mock(DaoBookingImpl.class);
   String stringJson="{\"user\":{\"emailId\":\"avani95@gmail.com\",\"name\":\"avani\",\"gender\":\"female\",\"age\":22,\"ticketNo\":8},\"flights\":[{\"flightNo\":347,\"origin\":\"indore\",\"destination\":\"bangalore\",\"date\":\"06/06/2018\",\"time\":\"12:24:36\",\"id\":15},{\"flightNo\":346,\"origin\":\"bangalore\",\"destination\":\"chandigarh\",\"date\":\"07/06/2018\",\"time\":\"11:24:36\",\"id\":15}]}\"";

   @Test
    public void getFlightBookingDetailsTest() throws Exception{

      // GetFlightBooking getFlightBooking= mock(GetFlightBooking.class);
       List<GetFlightBooking> getFlightBookings=new ArrayList<GetFlightBooking>();



       Mockito.mock(DaoBookingImpl.class);
//       when(dao.getFlightBookingDetails(
//               Mockito.anyInt())).thenReturn(String.valueOf((jdbcTemplate)));

       when(dao.getFlightBookingDetails(Mockito.anyInt())).thenReturn(stringJson);
       when(jdbcTemplate.query("select * from userdetails inner join flightdetails on userdetails.id=flightdetails.id where userdetails.ticketno=?",new BeanPropertyRowMapper(GetFlightBooking.class))).thenReturn(getFlightBookings);
//       RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//               "/getFlightBookings/8").accept(
//               MediaType.APPLICATION_JSON);
//
//
//       MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//       System.out.println(result.getResponse());
       String expected="{\"user\":{\"emailId\":\"avani95@gmail.com\",\"name\":\"avani\",\"gender\":\"female\",\"age\":22,\"ticketNo\":8},\"flights\":[{\"flightNo\":347,\"origin\":\"indore\",\"destination\":\"bangalore\",\"date\":\"06/06/2018\",\"time\":\"12:24:36\",\"id\":15},{\"flightNo\":346,\"origin\":\"bangalore\",\"destination\":\"chandigarh\",\"date\":\"07/06/2018\",\"time\":\"11:24:36\",\"id\":15}]}\"";
      // int expected=2;
       Assert.assertEquals(expected, stringJson);




   }
   @Test
    public void setUser() throws Exception {
       RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
               "/Users").accept(
               MediaType.APPLICATION_JSON);


       MvcResult result = mockMvc.perform(requestBuilder).andReturn();

       System.out.println(result.getResponse());
       String expected="{\"user\":{\"emailId\":\"avani95@gmail.com\",\"name\":\"avani\",\"gender\":\"female\",\"age\":22,\"ticketNo\":8},\"flights\":[{\"flightNo\":347,\"origin\":\"indore\",\"destination\":\"bangalore\",\"date\":\"06/06/2018\",\"time\":\"12:24:36\",\"id\":15},{\"flightNo\":346,\"origin\":\"bangalore\",\"destination\":\"chandigarh\",\"date\":\"07/06/2018\",\"time\":\"11:24:36\",\"id\":15}]}\"";

       JSONAssert.assertEquals(expected, stringJson, false);
   }
}
*/
