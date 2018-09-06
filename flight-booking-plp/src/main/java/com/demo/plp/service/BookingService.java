package com.demo.plp.service;

import com.demo.plp.entity.Bookings;
import com.demo.plp.entity.Flights;
import com.demo.plp.model.BookingsModel;
import com.demo.plp.model.FlightsModel;
import org.springframework.web.servlet.ModelAndView;

public interface BookingService {

    ModelAndView bookingHistory(String email);
    ModelAndView book(BookingsModel bookings, FlightsModel flightsModel);
    ModelAndView cancelTicket(BookingsModel bookings);
    void deleteTicket(Integer ticketNo);
}
