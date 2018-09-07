package com.flight.booking.springbootflightbooking.daoTest;

import com.flight.booking.springbootflightbooking.dao.DaoBookingImpl;
import com.flight.booking.springbootflightbooking.model.FlightBooking;
import com.flight.booking.springbootflightbooking.model.GetFlightBooking;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;


public class DaoBookingImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;


    @Mock
    private FlightBooking flightBooking ;

    @Mock
    GetFlightBooking getFlightBooking;


    @Autowired
    @InjectMocks
    DaoBookingImpl daoBookingImpl;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
   }


    @Test
    public void getFlightBookingDetailsTest() {

        List<GetFlightBooking> getFlightBookingList = new ArrayList<GetFlightBooking>();
        getFlightBooking=new GetFlightBooking();


        getFlightBooking.setAge(22);
        getFlightBooking.setEmailId("avani95@gmail.com");
        getFlightBooking.setGender("female");
        getFlightBooking.setTicketNo(8);
        getFlightBooking.setName("avani");
        getFlightBooking.setTime(Time.valueOf("12:24:36"));
        getFlightBooking.setOrigin("indore");
        getFlightBooking.setId(15);
        getFlightBooking.setFlightNo(347);
        getFlightBooking.setDestination("bangalore");
        getFlightBooking.setDate("06/06/2018");
        getFlightBookingList.add(getFlightBooking);
        when(jdbcTemplate.query(ArgumentMatchers.anyString(),ArgumentMatchers.any(Object[].class),ArgumentMatchers.any(RowMapper.class))).thenReturn(getFlightBookingList);
        flightBooking= daoBookingImpl.getFlightBookingDetails(8);
        Assert.assertNotNull(getFlightBookingList);
        Assert.assertNotNull(flightBooking);

    }

}
