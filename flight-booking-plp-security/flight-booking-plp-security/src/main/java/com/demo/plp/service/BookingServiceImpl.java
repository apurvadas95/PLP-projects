package com.demo.plp.service;

import com.demo.plp.dao.BookingDao;
import com.demo.plp.model.Bookings;
import com.demo.plp.model.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingDao bookingDao;


    public ModelAndView bookingHistory(String email) {

        ModelAndView mav=bookingDao.bookingHistory(email);
        return mav;
    }

    public ModelAndView book(Bookings bookings, Flights flights) {


        ModelAndView mav=bookingDao.book(bookings, flights);
        return mav;
    }

    public ModelAndView cancelTicket(Bookings bookings) {

        ModelAndView mav=bookingDao.cancelTicket(bookings);
        return mav;
    }


    public void deleteTicket(Integer ticketNo) {

        bookingDao.deleteTicket(ticketNo);
    }


}
