package com.demo.plp.dao;

import com.demo.plp.entity.Bookings;
import com.demo.plp.entity.Flights;
import com.demo.plp.model.BookingsModel;
import com.demo.plp.model.FlightsModel;
import org.springframework.web.servlet.ModelAndView;

public interface BookingDao {

    ModelAndView bookingHistory(String email);
    ModelAndView book(BookingsModel bookings, FlightsModel flights);
    ModelAndView cancelTicket(BookingsModel bookings);
    void deleteTicket(Integer ticketNo);
}
