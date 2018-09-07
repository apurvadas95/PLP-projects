package com.demo.plp.service;

import com.demo.plp.model.Bookings;
import com.demo.plp.model.Flights;
import org.springframework.web.servlet.ModelAndView;

public interface BookingService {

    ModelAndView bookingHistory(String email);
    ModelAndView book(Bookings bookings, Flights flights);
    ModelAndView cancelTicket(Bookings bookings);
    void deleteTicket(Integer ticketNo);
}
